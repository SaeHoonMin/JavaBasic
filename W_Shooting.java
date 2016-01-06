
// 자바 기반의 프레임워크 해설용 간단 샘플 게임


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.lang.*;
import java.util.*;
//import java.applet.Applet;
//import java.applet.AudioClip;

class W_Shooting
{

	public static void main(String[] args) 
	{
		System.out.println("Start!");
		W_Shooting_frame wsf=new W_Shooting_frame();
		//for(int i=0;i<360;i++) System.out.println(""+Math.sin(i));
	}

}
class W_Shooting_frame extends Frame implements KeyListener, Runnable
{
	//기본 윈도우를 형성하는 프레임을 만든다
	//KeyListener : 키보드 입력 이벤트를 받는다
	//Runnable : 스레드를 가능하게 한다

	public final static int UP_PRESSED		=0x001;
	public final static int DOWN_PRESSED	=0x002;
	public final static int LEFT_PRESSED	=0x004;
	public final static int RIGHT_PRESSED	=0x008;
	public final static int FIRE_PRESSED	=0x010;
	
	GameScreen gamescreen;//Canvas 객체를 상속한 화면 묘화 메인 클래스

	Thread mainwork;//스레드 객체
	boolean roof=true;//스레드 루프 정보
	Random rnd = new Random();	 // 랜덤 선언

	//게임 제어를 위한 변수
	int status;//게임의 상태
	int cnt;//루프 제어용 컨트롤 변수
	int delay;//루프 딜레이. 1/1000초 단위.
	long pretime;//루프 간격을 조절하기 위한 시간 체크값
	int keybuff;//키 버퍼값

	//AudioClip[] aclip=new AudioClip[3];

	//게임용 변수
	int score;//점수
	int mylife;//남은 목숨
	int gamecnt;//게임 흐름 컨트롤
	int scrspeed=16;//스크롤 속도
	int level;//게임 레벨

	int myx,myy;//플레이어 위치. 화면 좌표계에 *100 된 상태.
	int myspeed;//플레이어 이동 속도
	int mydegree;//플레이어 이동 방향
		//보통 4방향키-8방향 조작계에서는 이동 방향을 각도로 관리하지 않지만 여기서는 장래 터치스크린 인터페이스로
		//이식될 것을 고려해 4방향키 조작계를 0, 45, 90, 135, 180, 225, 270, 315도 방향으로 조작하는 것으로 한다.
	int mywidth, myheight;//플레이어 캐릭터의 너비 높이
	int mymode=1;//플레이어 캐릭터의 상태 (0부터 순서대로 무적,등장(무적),온플레이,데미지,사망)
	int myimg;//플레이어 이미지
	int mycnt;
	boolean myshoot=false;//총알 발사가 눌리고 있는가
	int myshield;//실드 남은 수비량

	int gScreenWidth=640;//게임 화면 너비
	int gScreenHeight=480;//게임 화면 높이

	Vector bullets=new Vector();//총알 관리. 총알의 갯수를 예상할 수 없기 때문에 가변적으로 관리한다.
	Vector enemies=new Vector();//적 캐릭터 관리.
	Vector effects=new Vector();//이펙트 관리
	Vector items=new Vector();//아이템 관리
	//가변 테이블을 사용한 관리는 처리속도에 악영향을 끼칠 수 있다.

	//속도를 위해서는 크기를 넉넉하게 잡은 테이블을 사용하는데, 소스가 지저분해지고, 불필요한 메모리를 낭비하게 되므로 적절한 것을 선택한다.
	//또, C 베이스 플랫폼으로 이식할 경우를 고려야 한다면 class나 Vector, Hashtable 같은 것은 이식하기 어려워지므로 가급적 피한다.
	
	W_Shooting_frame(){

		gamescreen=new GameScreen(this);//화면 묘화를 위한 캔버스 객체
		gamescreen.setBounds(0,0,gScreenWidth,gScreenHeight);
		add(gamescreen);//Canvas 객체를 프레임에 올린다

		systeminit();
		initialize();

		//기본적인 윈도우 정보 세팅. 게임과 직접적인 상관은 없이 게임 실행을 위한 창을 준비하는 과정.
		setIconImage(makeImage("c:\\rsc\\icon.png"));
		setBackground(new Color(0xffffff));//윈도우 기본 배경색 지정 (R=ff, G=ff, B=ff : 하얀색)
		setTitle("Fan Game");//윈도우 이름 지정
		setLayout(null);//윈도우의 레이아웃을 프리로 설정
		setBounds(100,100,640,480);//윈도우의 시작 위치와 너비 높이 지정
		setResizable(false);//윈도우의 크기를 변경할 수 없음
		setVisible(true);//윈도우 표시
		
		addKeyListener(this);//키 입력 이벤트 리스너 활성화
		addWindowListener(new MyWindowAdapter());//윈도우의 닫기 버튼 활성화
	}

	public void systeminit(){//프로그램 초기화

		status=0;
		cnt=0;
		delay=17;// 17/1000초 = 58 (프레임/초)
		keybuff=0;

		mainwork=new Thread(this);
		mainwork.start();
	}
	public void initialize(){//게임 초기화

		Init_TITLE();
		gamescreen.repaint();
	}

	// 스레드 파트
	public void run(){
		try
		{
			while(roof){
				pretime=System.currentTimeMillis();

				gamescreen.repaint();//화면 리페인트
				process();//각종 처리
				keyprocess();//키 처리

				if(System.currentTimeMillis()-pretime<delay) Thread.sleep(delay-System.currentTimeMillis()+pretime);
					//게임 루프를 처리하는데 걸린 시간을 체크해서 딜레이값에서 차감하여 딜레이를 일정하게 유지한다.
					//루프 실행 시간이 딜레이 시간보다 크다면 게임 속도가 느려지게 된다.

				if(status!=4) cnt++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// 키 이벤트 리스너 처리
	public void keyPressed(KeyEvent e) {
		//if(status==2&&(mymode==2||mymode==0)){
		if(status==2){
			switch(e.getKeyCode()){
			case KeyEvent.VK_SPACE:
				keybuff|=FIRE_PRESSED;
				break;
			case KeyEvent.VK_LEFT:
				keybuff|=LEFT_PRESSED;//멀티키의 누르기 처리
				break;
			case KeyEvent.VK_UP:
				keybuff|=UP_PRESSED;
				break;
			case KeyEvent.VK_RIGHT:
				keybuff|=RIGHT_PRESSED;
				break;
			case KeyEvent.VK_DOWN:
				keybuff|=DOWN_PRESSED;
				break;
			case KeyEvent.VK_1:
				if(myspeed>1) myspeed--;
				break;
			case KeyEvent.VK_2:
				if(myspeed<9) myspeed++;
				break;
			case KeyEvent.VK_3:
				if(status==2) status=4;
				break;
			/*case KeyEvent.VK_1:
				System.out.println("이펙트 테스트");
				Effect effect=new Effect(0, RAND(30,gScreenWidth-30)*100,RAND(30,gScreenHeight-30)*100, 0);
				effects.add(effect);
				break;*/
			default:
				break;
			}
		} else if(status!=2) keybuff=e.getKeyCode();
	}
	public void keyReleased(KeyEvent e) {
		//if(status==2&&(mymode==2||mymode==0)){
		//if(status==2){
			switch(e.getKeyCode()){
			case KeyEvent.VK_SPACE:
				keybuff&=~FIRE_PRESSED;
				myshoot=true;
				break;
			case KeyEvent.VK_LEFT:
				keybuff&=~LEFT_PRESSED;//멀티키의 떼기 처리
				break;
			case KeyEvent.VK_UP:
				keybuff&=~UP_PRESSED;
				break;
			case KeyEvent.VK_RIGHT:
				keybuff&=~RIGHT_PRESSED;
				break;
			case KeyEvent.VK_DOWN:
				keybuff&=~DOWN_PRESSED;
				break;
			}
		//}
		//PC 환경에서는 기본적으로 키보드의 반복입력을 지원하지만,
		//그렇지 않은 플랫폼에서는 키 버퍼값에 떼고 눌렀을 때마다 값을 변경해 리피트 여부를 제어한다.
	}
	public void keyTyped(KeyEvent e) {
	}

	// 각종 판단, 변수나 이벤트, CPU 관련 처리
	private void process(){
		switch(status){
		case 0://타이틀화면
			break;
		case 1://스타트
			process_MY();
			if(mymode==2) status=2;
			break;
		case 2://게임화면
			process_MY();
			process_ENEMY();
			process_BULLET();
			process_EFFECT();
			process_GAMEFLOW();
			process_ITEM();
			break;
		case 3://게임오버
			process_ENEMY();
			process_BULLET();
			process_GAMEFLOW();
			break;
		case 4://일시정지
			break;
		default:
			break;
		}
		if(status!=4) gamecnt++;
	}

	// 키 입력 처리
	// 키 이벤트에서 입력 처리를 할 경우, 이벤트 병목현상이 발생할 수 있으므로 이벤트에서는 키 버퍼만을 변경하고, 루프 내에서 버퍼값에 따른 처리를 한다.
	private void keyprocess(){
		switch(status){
		case 0://타이틀화면
			if(keybuff==KeyEvent.VK_SPACE) {
				Init_GAME();
				Init_MY();
				status=1;
			}
			break;
		case 2://게임화면
			if(mymode==2||mymode==0){
				switch(keybuff){
				case 0:
					mydegree=-1;
					myimg=0;
					break;
				case FIRE_PRESSED:
					mydegree=-1;
					myimg=6;
					break;
				case UP_PRESSED:
					mydegree=0;
					myimg=2;
					break;
				case UP_PRESSED|FIRE_PRESSED:
					mydegree=0;
					myimg=6;
					break;
				case LEFT_PRESSED:
					mydegree=90;
					myimg=4;
					break;
				case LEFT_PRESSED|FIRE_PRESSED:
					mydegree=90;
					myimg=6;
					break;
				case RIGHT_PRESSED:
					mydegree=270;
					myimg=2;
					break;
				case RIGHT_PRESSED|FIRE_PRESSED:
					mydegree=270;
					myimg=6;
					break;
				case UP_PRESSED|LEFT_PRESSED:
					mydegree=45;
					myimg=4;
					break;
				case UP_PRESSED|LEFT_PRESSED|FIRE_PRESSED:
					mydegree=45;
					myimg=6;
					break;
				case UP_PRESSED|RIGHT_PRESSED:
					mydegree=315;
					myimg=2;
					break;
				case UP_PRESSED|RIGHT_PRESSED|FIRE_PRESSED:
					mydegree=315;
					myimg=6;
					break;
				case DOWN_PRESSED:
					mydegree=180;
					myimg=2;
					break;
				case DOWN_PRESSED|FIRE_PRESSED:
					mydegree=180;
					myimg=6;
					break;
				case DOWN_PRESSED|LEFT_PRESSED:
					mydegree=135;
					myimg=4;
					break;
				case DOWN_PRESSED|LEFT_PRESSED|FIRE_PRESSED:
					mydegree=135;
					myimg=6;
					break;
				case DOWN_PRESSED|RIGHT_PRESSED:
					mydegree=225;
					myimg=2;
					break;
				case DOWN_PRESSED|RIGHT_PRESSED|FIRE_PRESSED:
					mydegree=225;
					myimg=6;
					break;
				default:
					//System.out.println(""+keybuff);
					keybuff=0;
					mydegree=-1;
					myimg=0;
					break;
				}
			}
			break;
		case 3:
			if(gamecnt++>=200&&keybuff==KeyEvent.VK_SPACE){
				Init_TITLE();
				status=0;
				keybuff=0;
			}
			break;
		case 4:
			if(gamecnt++>=200&&keybuff==KeyEvent.VK_3) status=2;
			break;
		default:
			break;
		}
	}


	//서브루틴 일람
	public void Init_TITLE(){
		int i;
		/*gamescreen.bg=null;
		gamescreen.bg_f=null;
		for(i=0;i<4;i++) gamescreen.cloud[i]=null;
		for(i=0;i<4;i++) gamescreen.bullet[i]=null;
		gamescreen.enemy[0]=null;
		gamescreen.explo=null;
		gamescreen.item=null;
		gamescreen._start=null;
		gamescreen._over=null;
		System.gc();*/

		gamescreen.title=makeImage("c:\\rsc\\title.png");
		gamescreen.title_key=makeImage("c:\\rsc\\pushspace.png");

		//aclip[0]=myaudio.getClip("./snd/bgm_0.au");
		//aclip[0].loop();
	}
	public void Init_GAME(){
		int i;
		/*gamescreen.title=null;
		gamescreen.title_key=null;
		System.gc();*/

		gamescreen.bg=makeImage("c:\\rsc\\구름.JPG");//bg.png
		gamescreen.bg_f=makeImage("c:\\rsc\\bg_f.png");
		for(i=0;i<4;i++) gamescreen.cloud[i]=makeImage("c:\\rsc\\cloud"+i+".png");
		for(i=0;i<4;i++) gamescreen.bullet[i]=makeImage("c:\\rsc\\game\\bullet_"+i+".png");
		gamescreen.enemy[0]=makeImage("c:\\rsc\\game\\enemy0.png");
		gamescreen.explo=makeImage("c:\\rsc\\game\\explode.png");
		gamescreen.item[0]=makeImage("c:\\rsc\\game\\item0.png");
		gamescreen.item[1]=makeImage("c:\\rsc\\game\\item1.png");
		gamescreen._start=makeImage("c:\\rsc\\game\\start.png");
		gamescreen._over=makeImage("c:\\rsc\\game\\gameover.png");
		gamescreen.shield=makeImage("c:\\rsc\\game\\shield.png");
		keybuff=0;
		bullets.clear();
		enemies.clear();
		effects.clear();
		items.clear();
		level=0;
	}
	public void Init_MY(){
		for(int i=0;i<9;i++){
			if(i<10)
				gamescreen.chr[i]=makeImage("c:\\rsc\\player\\my_0"+i+".png");
			else
				gamescreen.chr[i]=makeImage("c:\\rsc\\player\\my_"+i+".png");
		}
		Init_MYDATA();
	}
	public void Init_MYDATA(){
		score=0;
		myx=0;
		myy=23000;
		myspeed=4;
		mydegree=-1;
		//mywidth, myheight;//플레이어 캐릭터의 너비 높이
		mymode=1;
		myimg=2;
		mycnt=0;
		mylife=3;
		keybuff=0;
	}
	public void process_MY(){
		Bullet shoot;
		switch(mymode){
		case 1:
			myx+=200;
			if(myx>20000) mymode=2;
			break;
		case 0:
			if(mycnt--==0) {
				mymode=2;
				myimg=0;
			}
		case 2:
			if(mydegree>-1) {
				myx-=(myspeed*Math.sin(Math.toRadians(mydegree))*100);
				myy-=(myspeed*Math.cos(Math.toRadians(mydegree))*100);
			}
			if(myimg==6) {
				myx-=20;
				if(cnt%4==0||myshoot){
					myshoot=false;
					shoot=new Bullet(myx+2500, myy+1500, 0, 0, RAND(245,265), 8);
					bullets.add(shoot);
					shoot=new Bullet(myx+2500, myy+1500, 0, 0, RAND(268,272), 9);
					bullets.add(shoot);
					shoot=new Bullet(myx+2500, myy+1500, 0, 0, RAND(275,295), 8);
					bullets.add(shoot);
				}
				//8myy+=70;
			}
			break;
		case 3:
			//keybuff=0;
			myimg=8;
			if(mycnt--==0) {
				mymode=0;
				mycnt=50;
			}
			break;
		}
		if(myx<2000) myx=2000;
		if(myx>62000) myx=62000;
		if(myy<3000) myy=3000;
		if(myy>45000) myy=45000;
	}
	public void process_ENEMY(){
		int i;
		Enemy buff;
		for(i=0;i<enemies.size();i++){
			buff=(Enemy)(enemies.elementAt(i));
			if(!buff.move()) enemies.remove(i);
		}
	}
	public void process_BULLET(){
		Bullet buff;
		Enemy ebuff;
		Effect expl;
		int i,j, dist;
		for(i=0;i<bullets.size();i++){
			buff=(Bullet)(bullets.elementAt(i));
			buff.move();
			if(buff.dis.x<10||buff.dis.x>gScreenWidth+10||buff.dis.y<10||buff.dis.y>gScreenHeight+10) {
				bullets.remove(i);//화면 밖으로 나가면 총알 제거
				continue;
			}
			if(buff.from==0) {//플레이어가 쏜 총알이 적에게 명중 판정
				for(j=0;j<enemies.size();j++){
					ebuff=(Enemy)(enemies.elementAt(j));
					dist=GetDistance(buff.dis.x,buff.dis.y, ebuff.dis.x,ebuff.dis.y);
					if(dist<1500) {//중간점 거리가 명중 판정이 가능한 범위에 왔을 때
						if(ebuff.life--<=0){//적 라이프 감소
							enemies.remove(j);//적 캐릭터 소거
							expl=new Effect(0, ebuff.pos.x, buff.pos.y, 0);
							effects.add(expl);//폭발 이펙트 추가
							Item tem=new Item(ebuff.pos.x, buff.pos.y, RAND(1,(level+1)*20)/((level+1)*20));//난수 결과가 최대값일 때만 생성되는 아이템이 1이 된다
							items.add(tem);
						}
						expl=new Effect(0, ebuff.pos.x, buff.pos.y, 0);
						effects.add(expl);
						score++;//점수 추가
						bullets.remove(i);//총알 소거
					}
				}
			} else {//적이 쏜 총알이 플레이어에게 명중 판정
				if(mymode!=2) continue;
				dist=GetDistance(myx/100,myy/100, buff.dis.x,buff.dis.y);
				if(dist<500) {
					if(myshield==0){
						mymode=3;
						mycnt=30;
						bullets.remove(i);
						expl=new Effect(0, myx-2000, myy, 0);
						effects.add(expl);
						if(--mylife<=0) {
							status=3;
							gamecnt=0;
						}
					} else {//실드가 있을 경우
						myshield--;
						bullets.remove(i);
					}
				}
			}
		}
	}
	public void process_EFFECT(){
		int i;
		Effect buff;
		for(i=0;i<effects.size();i++){
			buff=(Effect)(effects.elementAt(i));
			if(cnt%3==0) buff.cnt--;
			if(buff.cnt==0) effects.remove(i);
		}
	}
	public void process_GAMEFLOW(){
		int control=0;
		int newy=0, mode=0;
		if(gamecnt<500) control=1;
		else if(gamecnt<1000) control=2;
		else if(gamecnt<1300) control=0;
		else if(gamecnt<1700) control=1;
		else if(gamecnt<2000) control=2;
		else if(gamecnt<2400) control=3;
		else {
			gamecnt=0;
			level++;
		}
		if(control>0) {
			newy=RAND(30,gScreenHeight-30)*100;
			if(newy<24000) mode=0; else mode=1;
		}
		switch(control){
		case 1:
			if(gamecnt%90==0) {
				Enemy en=new Enemy(this, 0, gScreenWidth*100, newy, 0,mode);
				enemies.add(en);
			}
			break;
		case 2:
			if(gamecnt%50==0) {
				Enemy en=new Enemy(this, 0, gScreenWidth*100, newy, 0,mode);
				enemies.add(en);
			}
			break;
		case 3:
			if(gamecnt%20==0) {
				Enemy en=new Enemy(this, 0, gScreenWidth*100, newy, 0,mode);
				enemies.add(en);
			}
			break;
		}
	}
	public void process_ITEM(){
		int i, dist;
		Item buff;
		for(i=0;i<items.size();i++){
			buff=(Item)(items.elementAt(i));
			dist=GetDistance(myx/100,myy/100, buff.dis.x,buff.dis.y);
			if(dist<1000) {//아이템 획득
				switch(buff.kind){
				case 0://일반 득점
					score+=100;
					break;
				case 1://실드
					myshield=5;
					break;
				}
				items.remove(i);
			} else
				if(buff.move()) items.remove(i);
		}
	}

	public Image makeImage(String furl){
		Image img;
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage(furl);
		try {
			//여기부터
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 0);
			mt.waitForID(0);
			//여기까지, getImage로 읽어들인 이미지가 로딩이 완료됐는지 확인하는 부분
		} catch (Exception ee) {
			ee.printStackTrace();
			return null;
		}	
		return img;
	}
	public int GetDistance(int x1,int y1,int x2,int y2){
		return Math.abs((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
	}
	public int RAND(int startnum, int endnum) //랜덤범위(startnum부터 ramdom까지), 랜덤값이 적용될 변수.
	{
		int a, b;
		if(startnum<endnum)
			b = endnum - startnum; //b는 실제 난수 발생 폭
		else
			b = startnum - endnum;
		a = Math.abs(rnd.nextInt()%(b+1));
		return (a+startnum);
	}
	int getAngle(int sx, int sy, int dx, int dy){
		int vx=dx-sx;
		int vy=dy-sy;
		double rad=Math.atan2(vx,vy);
		int degree=(int)((rad*180)/Math.PI);
		return (degree+180);
	}

	public boolean readGameFlow(String fname){
		String buff;
		try
		{
			BufferedReader fin=new BufferedReader(new FileReader(fname));
			if((buff=fin.readLine())!=null) {
				System.out.println(Integer.parseInt(buff));
			}
			fin.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

class GameScreen extends Canvas
{
	//실제 게임의 메인 제어를 행하는 클래스
	//가급적 화면 출력에서는 게임에서 공통으로 쓰이는 변수값의 변경 등을 행하지 않는 것이 좋다.
	W_Shooting_frame main;
	int cnt, gamecnt;

	//화면 그리기용 변수
	int x,y;//플레이어 캐릭터의 좌표

	Image dblbuff;//더블버퍼링용 백버퍼
	Graphics gc;//더블버퍼링용 그래픽 컨텍스트

	Image bg,bg_f;//배경화면
	Image cloud[]=new Image[5];//구름
	Image title, title_key;//타이틀화면

	Image chr[]=new Image[9];//플레이어 캐릭터
	Image enemy[]=new Image[5];//적 캐릭터
	Image bullet[]=new Image[5];//총알
	Image explo;//폭염
	Image item[]=new Image[3];//아이템

	Image _start;//시작로고
	Image _over;//게임오버로고
	Image shield;//실드

	Font font;

	int v[]={-2,-1,0,1,2,1,0,-1};
	int v2[]={-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7};
	int step=0;

	GameScreen(W_Shooting_frame main){
		this.main=main;
		font=new Font("Default",Font.PLAIN,9);
	}

	public void paint(Graphics g){
		if(gc==null) {
			dblbuff=createImage(main.gScreenWidth,main.gScreenHeight);//더블 버퍼링용 오프스크린 버퍼 생성. 필히 paint 함수 내에서 해 줘야 한다. 그렇지 않으면 null이 반환된다.
			if(dblbuff==null) System.out.println("오프스크린 버퍼 생성 실패");
			else gc=dblbuff.getGraphics();//오프스크린 버퍼에 그리기 위한 그래픽 컨텍스트 획득
			return;
		}
		update(g);
	}
	public void update(Graphics g){//화면 깜박거림을 줄이기 위해, paint에서 화면을 바로 묘화하지 않고 update 메소드를 호출하게 한다.
		cnt=main.cnt;
		gamecnt=main.gamecnt;
		if(gc==null) return;
		dblpaint();//오프스크린 버퍼에 그리기
		g.drawImage(dblbuff,0,0,this);//오프스크린 버퍼를 메인화면에 그린다.
	}
	public void dblpaint(){
		//실제 그리는 동작은 이 함수에서 모두 행한다.
		switch(main.status){
		case 0://타이틀화면
			Draw_TITLE();
			gc.setColor(new Color(0));
			gc.drawString("Education ver.", 10,40);
			break;
		case 1://게임 스타트
			Draw_BG();
			Draw_MY();
			Draw_BG2();
			drawImageAnc(_start, 0,270, 3);
			break;
		case 2://게임화면
		case 4://일시정지
			Draw_BG();
			Draw_MY();
			Draw_ENEMY();
			Draw_BULLET();
			Draw_EFFECT();
			Draw_ITEM();
			Draw_BG2();
			Draw_UI();
			break;
		case 3://게임오버
			Draw_BG();
			Draw_ENEMY();
			Draw_BULLET();
			Draw_BG2();
			drawImageAnc(_over, 320,240, 4);
			Draw_UI();
			break;
		default:
			break;
		}
	}

	public void Draw_TITLE(){
		gc.drawImage(title,0,0,this);
		if(cnt%20<10) gc.drawImage(title_key, 320-201,370, this);
	}
	public void Draw_BG(){
		int i;
		gc.drawImage(bg,0,0,this);
		for(i=0;i<12;i++) gc.drawImage(cloud[3], i*64-((cnt/2)%128), 370, this);
		for(i=-1;i<14;i++) gc.drawImage(cloud[2], i*64-(cnt%128)*2, 395, this);
	}
	public void Draw_BG2(){
		int i;
		step=(cnt%(bg_f.getWidth(this)/main.scrspeed))*main.scrspeed;
		gc.drawImage(bg_f,0-step,540-bg_f.getHeight(this)+v[(cnt/20)%8]*2,this);
		//System.out.println("요기"+step);
		if(step>=bg_f.getWidth(this)-main.gScreenWidth) {
			gc.drawImage(bg_f,0-step+bg_f.getWidth(this),540-bg_f.getHeight(this)+v[(cnt/20)%8]*2,this);
		}
		for(i=-1;i<14;i++) gc.drawImage(cloud[0], i*128-(cnt%128)*8, 435, this);
	}
	public void Draw_MY(){
		int myx,myy;
		myx=main.myx/100;
		myy=main.myy/100;
		if(main.myshield>2) drawImageAnc(shield, (int)(Math.sin(Math.toRadians((cnt%72)*5))*16+myx), (int)(Math.cos(Math.toRadians((cnt%72)*5))*16+myy), (main.cnt/6%7)*64,0, 64,64, 4);//실드 라이프가 3 이상
		else if(main.myshield>0&&main.cnt%4<2) drawImageAnc(shield, (int)(Math.sin(Math.toRadians((cnt%72)*5))*16+myx), (int)(Math.cos(Math.toRadians((cnt%72)*5))*16+myy), (main.cnt/6%7)*64,0, 64,64, 4);//실드 라이프가 1, 2면 점멸
		switch(main.mymode){
		case 0://무적
		case 1://무적이면서 등장
			if(main.cnt%20<10) drawImageAnc(chr[2+(main.cnt/5)%2], myx, myy, 4);
			break;
		case 2://온플레이
			if(main.myimg==6) drawImageAnc(chr[main.myimg+(main.cnt/3)%2], myx, myy, 4);
			else if(main.myimg!=8) drawImageAnc(chr[main.myimg+(main.cnt/5)%2], myx, myy, 4);
			else if(main.myimg==8) drawImageAnc(chr[main.myimg], myx, myy, 4);
			break;
		case 3://데미지
			if(main.cnt%6<3) drawImageAnc(chr[8], myx, myy, 4);
			break;
		}
	}
	public void Draw_ENEMY(){
		int i;
		Enemy buff;
		for(i=0;i<main.enemies.size();i++){
			buff=(Enemy)(main.enemies.elementAt(i));
			drawImageAnc(enemy[0], buff.dis.x, buff.dis.y, ((cnt/8)%7)*36,0, 36,36, 4);
		}
	}
	public void Draw_BULLET(){
		Bullet buff;
		int i;
		for(i=0;i<main.bullets.size();i++){
			buff=(Bullet)(main.bullets.elementAt(i));
			switch(buff.img_num){
			case 0:
			case 1:
			case 2:
			case 3:
				drawImageAnc(bullet[buff.img_num], buff.dis.x-6,buff.dis.y-6, 4);
				break;
			}
		}
	}
	public void Draw_EFFECT(){
		int i;
		Effect buff;
		for(i=0;i<main.effects.size();i++){
			buff=(Effect)(main.effects.elementAt(i));
			drawImageAnc(explo, buff.dis.x, buff.dis.y, ((16-buff.cnt)%4)*64,((16-buff.cnt)/4)*64,64,64, 4);
		}
	}
	public void Draw_ITEM(){
		int i;
		Item buff;
		for(i=0;i<main.items.size();i++){
			buff=(Item)(main.items.elementAt(i));
			drawImageAnc(item[buff.kind], buff.dis.x, buff.dis.y, ((main.cnt/4)%7)*36,0, 36,36, 4);
		}
	}
	public void Draw_UI(){
		String str1="SCORE "+main.score+"   LIFE "+main.mylife+"   SPEED "+main.myspeed+"  LEVEL "+(main.level+1);
		String str2="[1] Speed down   [2] Speed up   [3] Pause";
		gc.setColor(new Color(0));
		gc.drawString(str1, 9,40);
		gc.drawString(str1, 11,40);
		gc.drawString(str1, 10,39);
		gc.drawString(str1, 10,41);
		gc.setColor(new Color(0xffffff));
		gc.drawString(str1, 10,40);

		gc.setColor(new Color(0));
		gc.drawString(str2, 9,main.gScreenHeight-10);
		gc.drawString(str2, 11,main.gScreenHeight-10);
		gc.drawString(str2, 10,main.gScreenHeight-11);
		gc.drawString(str2, 10,main.gScreenHeight-9);
		gc.setColor(new Color(0xffffff));
		gc.drawString(str2, 10,main.gScreenHeight-10);
	}
	public void drawImageAnc(Image img, int x, int y, int anc){
		//앵커값을 참조해 이미지 출력 위치를 보정한다.
		//예) anc==0 : 좌상단이 기준, anc==4 : 이미지 중앙이 기준
		int imgw, imgh;
		imgw=img.getWidth(this);
		imgh=img.getHeight(this);
		x=x-(anc%3)*(imgw/2);
		y=y-(anc/3)*(imgh/2);
		
		gc.drawImage(img, x,y, this);
	}
	public void drawImageAnc(Image img, int x, int y, int sx,int sy, int wd,int ht, int anc){//sx,sy부터 wd,ht만큼 클리핑해서 그린다.
		if(x<0) {
			wd+=x;
			sx-=x;
			x=0;
		}
		if(y<0) {
			ht+=y;
			sy-=y;
			y=0;
		}
		if(wd<0||ht<0) return;
		x=x-(anc%3)*(wd/2);
		y=y-(anc/3)*(ht/2);
		gc.setClip(x, y, wd, ht);
		gc.drawImage(img, x-sx, y-sy, this);
		gc.setClip(0,0, main.gScreenWidth+10,main.gScreenHeight+30);
	}


}
class Bullet
{
	// 게임에 등장하는 총알을 처리하기 위한 클래스
	// 메모리 효율을 위해서는 총알에 관한 최소한의 정보만 담는 것이 좋지만, 처리 샘플을 위해 간단한 자체 처리 루틴을 포함한다.
	Point dis;//총알의 표시 좌표. 실제 좌표보다 *100 상태이다.
	Point pos;//총알의 계산 좌표. 실제 좌표보다 *100 상태이다.
	Point _pos;//총알의 직전 좌표
	int degree;//총알의 진행 방향 (각도)
		//총알의 진행 방향은 x, y 증가량으로도 표시 가능하다. 하지만 그 경우 정밀한 탄막 구현이 어려워진다.
	int speed;//총알의 이동 속도
	int img_num;//총알의 이미지 번호
	int from;//총알을 누가 발사했는가
	Bullet(int x, int y, int img_num, int from, int degree, int speed){
		pos=new Point(x,y);
		dis=new Point(x/100,y/100);
		_pos=new Point(x,y);
		this.img_num=img_num;
		this.from=from;
		this.degree=degree;
		this.speed=speed;
	}
	public void move(){
		_pos=pos;//이전 좌표 보존
		pos.x-=(speed*Math.sin(Math.toRadians(degree))*100);
		pos.y-=(speed*Math.cos(Math.toRadians(degree))*100);
		dis.x=pos.x/100;
		dis.y=pos.y/100;
		//if(pos.x<0||pos.y>gScreenWidth*100||pos.y<0||pos.y>gScreenHeight*100) ebullet[i].pic=255;
	}
}
class Enemy
{
	//게임에 등장하는 적 캐릭터 관리 클래스
	W_Shooting_frame main;
	Point pos;
	Point _pos;
	Point dis;
	int img;
	int kind;
	int life;
	int mode;
	int cnt;
	int shoottype;
	Bullet bul;
	Enemy(W_Shooting_frame main, int img, int x, int y, int kind, int mode){
		this.main=main;
		pos=new Point(x,y);
		_pos=new Point(x,y);
		dis=new Point(x/100,y/100);
		this.kind=kind;
		this.img=img;
		this.mode=mode;
		life=6+main.RAND(0,5)*main.level;//게임 레벨에 따라 라이프와 탄을 쏘는 시간이 짧아진다
		cnt=main.RAND(main.level*5,80);
		shoottype=main.RAND(0,4);
	}
	public boolean move(){
		boolean ret=true;

		switch(shoottype){//공격 형태에 따라 각기 다른 공격을 한다.
		case 0://플레이어를 향해 3발을 점사한다
			if(cnt%100==0||cnt%103==0||cnt%106==0) {//cnt로 공격 간격을 체크한다
				bul=new Bullet(pos.x, pos.y, 2, 1, main.getAngle(pos.x,pos.y,main.myx,main.myy), 6);
				main.bullets.add(bul);
			}
			break;
		case 1://타이머에 맞춰 4방향탄을 발사한다
			if(cnt%90==0||cnt%100==0||cnt%110==0) {
				bul=new Bullet(pos.x, pos.y, 2, 1, (0+(cnt%36)*10)%360, 6);
				main.bullets.add(bul);
				bul=new Bullet(pos.x, pos.y, 2, 1, (30+(cnt%36)*10)%360, 6);
				main.bullets.add(bul);
				bul=new Bullet(pos.x, pos.y, 2, 1, (60+(cnt%36)*10)%360, 6);
				main.bullets.add(bul);
				bul=new Bullet(pos.x, pos.y, 2, 1, (90+(cnt%36)*10)%360, 6);
				main.bullets.add(bul);
			}
			break;
		case 2://짧은 간격으로 플레이어 근처를 향해 한 발씩 발사한다
			if(cnt%30==0||cnt%60==0||cnt%90==0||cnt%120==0||cnt%150==0||cnt%180==0) {
				bul=new Bullet(pos.x, pos.y, 2, 1, (main.getAngle(pos.x,pos.y,main.myx,main.myy)+main.RAND(-20,20))%360, 6);
				main.bullets.add(bul);
			}
			break;
		case 3://플레이어를 향해 3갈래탄을 발사한다
			if(cnt%90==0||cnt%110==0||cnt%130==0){
				bul=new Bullet(pos.x, pos.y, 2, 1, main.getAngle(pos.x,pos.y,main.myx,main.myy), 6);
				main.bullets.add(bul);
				bul=new Bullet(pos.x, pos.y, 2, 1, (main.getAngle(pos.x,pos.y,main.myx,main.myy)-20)%360, 6);
				main.bullets.add(bul);
				bul=new Bullet(pos.x, pos.y, 2, 1, (main.getAngle(pos.x,pos.y,main.myx,main.myy)+20)%360, 6);
				main.bullets.add(bul);
			}
			break;
		case 4://아무런 공격도 하지않는다
			break;
		}

		switch(kind){
		case 0:
			switch(mode){
			case 0:
				pos.x-=500;
				pos.y+=80;
				if(pos.x<main.myx) mode=2;
				break;
			case 1:
				pos.x-=500;
				pos.y-=80;
				if(pos.x<main.myx) mode=3;
				break;
			case 2:
				pos.x+=600;
				pos.y+=240;
				break;
			case 3:
				pos.x+=600;
				pos.y-=240;
				break;
			}
			break;
		case 1:
			break;
		}
		dis.x=pos.x/100;
		dis.y=pos.y/100;
		if(dis.x<0||dis.x>640||dis.y<0||dis.y>480) ret=false;

		cnt++;
		return ret;
	}
}
class Effect
{
	//폭발 등의 이펙트 관리 클래스
	Point pos;
	Point _pos;
	Point dis;
	int img;
	int kind;
	int cnt;
	Effect(int img, int x, int y, int kind){
		pos=new Point(x,y);
		_pos=new Point(x,y);
		dis=new Point(x/100,y/100);
		this.kind=kind;
		this.img=img;
		cnt=16;
	}
}
class Item
{
	//아이템 관리 클래스
	Point pos;
	Point dis;
	int speed;
	int cnt;
	int kind;
	Item(int x, int y, int kind){
		this.kind=kind;
		pos=new Point(x,y);
		dis=new Point(x/100,y/100);
		speed=-200;
		cnt=0;
	}
	public boolean move(){
		boolean ret=false;
		pos.x-=speed;
		cnt++;
		if(cnt>=50) speed=200;
		else if(cnt>=30) speed=100;
		else if(cnt>=20) speed=-100;
		dis.x=pos.x/100;
		if(pos.x<0) ret=true;
		return ret;
	}
}

class MyWindowAdapter extends WindowAdapter
{
	// 윈도우를 닫기 위한 부가 클래스. 실제 닫는 동작은
	// setVisible(false);
	// dispose();
	// System.exit(0);
	// 이상 세 라인으로 이루어진다.
	//
	MyWindowAdapter(){
	}
	public void windowClosing(WindowEvent e) {
		Window wnd = e.getWindow();
		wnd.setVisible(false);
		wnd.dispose();
		System.exit(0);
	}
}

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 기타문자열 {
	public static void main(String[] args)
			throws Exception
	{
		Document doc = Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
		
		//System.out.println(doc);
		
/*  		<td class="title">
		<div class="tit3">
			<a href="/movie/bi/mi/basic.nhn?code=143245" title="셜록: 유령신부">셜록: 유령신부</a>
		</div>
		</td>
*/
		Elements data = doc.select("td.title div.tit3");
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).text());
		}
	}
}

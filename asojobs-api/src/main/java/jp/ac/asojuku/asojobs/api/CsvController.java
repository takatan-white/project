package jp.ac.asojuku.asojobs.api;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("csv")
public class CsvController {
	@RequestMapping("/download")
	public void download(HttpServletResponse res) throws Exception {
		// ContentTypeを指定
		res.setContentType("text/csv;charset=UTF-8");
		String fileName = new String("asojobs.csv".getBytes("UTF-8"), "UTF-8");
		// Headerを設定
		res.setCharacterEncoding("UTF-8");
		res.setHeader("Content-Disposition", "attachment; filename="+fileName);
		// 内容を出力
		PrintWriter writer = res.getWriter();
		
		writer.write("hello, world, こんにちは,世界");
		writer.println();
		writer.write("hello, world, こんにちは,世界");
		writer.println();
		writer.write("hello, world, こんにちは,世界");
		writer.close();
	}
}

package com.songshui.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songshui.util.MessageUtil;
import com.songshui.util.ResponseUtil;
import com.songshui.util.SignUtil;

@Controller
@RequestMapping(value = TestController.DIR)
public class TestController {
	public static final String DIR = "/songshui";

	@ResponseBody
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public void testGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("doget|"+"begin:"+System.currentTimeMillis());
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			PrintWriter out = response.getWriter();
			out.print(echostr);
			System.out.println("doget|"+"after:"+System.currentTimeMillis());
			out.close();
			out = null;

		}

	}

	@ResponseBody
	@RequestMapping(value = "test.do", method = RequestMethod.POST)
	public void testPost(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("dopost|"+"begin:"+System.currentTimeMillis());
		Map<String, String> map = null;
		try {
			map = MessageUtil.parseXml(request);
		} catch (Exception e) {
			e.printStackTrace();
			// return "error";
		}
		String respMessage = ResponseUtil.processRequest(map);

		try {
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			System.out.println("dopost|"+"after:"+System.currentTimeMillis());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return respMessage;
	}
}

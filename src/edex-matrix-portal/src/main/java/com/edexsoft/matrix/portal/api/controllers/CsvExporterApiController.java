package com.edexsoft.matrix.portal.api.controllers;

public class CsvExporterApiController {
//	@RequestMapping(value = "/api/root/fans/export", method = RequestMethod.GET)
//	public void downloadCSV(
//			HttpServletResponse response, 
//			@RequestParam("f1") String f1,
//			@RequestParam("f2") String f2, 
//			@RequestParam("pageIndex") long pageIndex, @RequestParam("pageSize") long pageSize) throws IOException {
//
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1 = null;
//		try {
//			d1 = format.parse(f1);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		PagedData<e1> dData = fooService.ExportAll(f1,d1, pageIndex, pageSize);
//
//		ArrayList<String> rows = new ArrayList<String>();
//		rows.add("姓名,电话,身份证号,注册地区,角色,房号,注册日期\t"); // 性别,
//
//		E1 oEentity = null;
//		SimpleDateFormat sdfReg = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for (int i = 0; i < dData.getEntities().size(); i++) {
//			oWxUser = dData.getEntities().get(i);
//			String s = String.format("%s,%s,%s,%s,%s,%s,%s\t", // ,%s
//					ClearString(oEentity.geName()))
//			rows.add(s);
//		}
//
//		// 这用utf-8会在excel打开时乱码，所以只能用GBK
//		response.setContentType("text/csv;charset=GBK");
//		String reportName = "user_export.csv";
//		response.setHeader("Content-disposition", "attachment;filename=" + reportName);
//
//		Iterator<String> iter = rows.iterator();
//		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "GBK"), true);
//		while (iter.hasNext()) {
//			String outputString = (String) iter.next();
//			out.println(outputString);
//		}
//		out.flush();
//	}
}

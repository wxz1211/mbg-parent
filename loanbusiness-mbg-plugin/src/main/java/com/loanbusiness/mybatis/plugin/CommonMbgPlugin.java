package com.loanbusiness.mybatis.plugin;


import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.plugins.CaseInsensitiveLikePlugin;

public class CommonMbgPlugin extends PluginAdapter{

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}


	/**
	 * @param introspectedTable
	 * @description:  
	 * @author jie.xu 
	 * @date 2016年2月22日 下午3:51:03
	 */
	private void removeColumn(IntrospectedTable introspectedTable,String...strings) {
		Iterator<IntrospectedColumn> iter = introspectedTable.getBaseColumns()
	                .iterator();
		 while (iter.hasNext()) {
			  IntrospectedColumn introspectedColumn = iter.next();
			  
			  for(String column : strings){
				  if(column.equals(introspectedColumn.getActualColumnName())){
					  iter.remove();
					  break;
				  }
			  }
		 }
	}



	@Override
	public boolean sqlMapBaseColumnListElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		removeColumn(introspectedTable,"gmt_create","gmt_update");
		return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
	}


}

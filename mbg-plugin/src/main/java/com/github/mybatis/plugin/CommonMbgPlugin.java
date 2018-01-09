package com.github.mybatis.plugin;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Iterator;
import java.util.List;

/**
 * @author xianzhi.wang
 */
public class CommonMbgPlugin extends PluginAdapter {

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
     * removeColumn
     * @param introspectedTable
     * @param strings
     */
    private void removeColumn(IntrospectedTable introspectedTable, String... strings) {
        Iterator<IntrospectedColumn> iter = introspectedTable.getBaseColumns()
                .iterator();
        while (iter.hasNext()) {
            IntrospectedColumn introspectedColumn = iter.next();

            for (String column : strings) {
                if (column.equals(introspectedColumn.getActualColumnName())) {
                    iter.remove();
                    break;
                }
            }
        }
    }


    @Override
    public boolean sqlMapBaseColumnListElementGenerated(XmlElement element,
                                                        IntrospectedTable introspectedTable) {
        removeColumn(introspectedTable, "gmt_create", "gmt_update");
        return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
    }


}

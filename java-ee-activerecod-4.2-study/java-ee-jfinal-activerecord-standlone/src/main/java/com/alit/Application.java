package com.alit;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alit.model.UrlManager;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Config;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.druid.DruidPlugin;

public class Application {

  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost/alit_url_manager";
    String jdbcUser = "root";
    String jdbcPswd = "root";
    DruidPlugin dp = new DruidPlugin(jdbcUrl, jdbcUser, jdbcPswd);
    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
    arp.addMapping("url_manager", UrlManager.class);
    dp.start();
    arp.start();
    Set<Entry<String, Config>> configSet = DbKit.getConfigSet();
    System.out.println(configSet);
    List<UrlManager> find = UrlManager.dao.find("select * from url_manager");
    System.out.println(find);
  }
}

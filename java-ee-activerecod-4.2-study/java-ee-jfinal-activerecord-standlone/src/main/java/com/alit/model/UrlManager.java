package com.alit.model;

import com.jfinal.plugin.activerecord.Model;

public class UrlManager extends Model<UrlManager> {
  private static final long serialVersionUID = 1L;
  public static final UrlManager dao = new UrlManager().dao();
}

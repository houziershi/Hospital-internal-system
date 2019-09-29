package com.baoan.hospital.system.UI.data;

import java.io.Serializable;

/**
 * Discription:
 *
 * @author guokun
 * @date 2019/9/29
 */
public class XH implements Serializable {

    private String title;
    private String description;

    public XH(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

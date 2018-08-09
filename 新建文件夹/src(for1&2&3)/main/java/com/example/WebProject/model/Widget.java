package com.example.WebProject.model;

import javax.persistence.*;

import com.example.WebProject.model.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Widget {
    public int getWidget_order() {
        return widget_order;
    }

    public void setWidget_order(int widget_order) {
        this.widget_order = widget_order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public static enum widgetType {
        YOUTUBE,
        HEADING,
        IMAGE,
        LIST,
        PARAGRAPH,
        LINK;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private widgetType type;
    private int widget_order;
    private String title;
    private String text;
    private String style;
    private String width;
    private String height;
    private String src;
    private String listItems;
    private boolean ordered;
    private int size;
    private String href;
    @ManyToOne
    @JsonIgnore
    private Topic topic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public widgetType getType() {
        return type;
    }

    public void setType(widgetType type) {
        this.type = type;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getListItems() {
        return listItems;
    }

    public void setListItems(String listItems) {
        this.listItems = listItems;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
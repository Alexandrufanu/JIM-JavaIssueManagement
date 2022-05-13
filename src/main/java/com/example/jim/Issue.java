package com.example.jim;

import java.sql.SQLException;
import java.util.ArrayList;

// add colors for issue progress
// Admin Page - which can give Permissions to other users
// interfaces
// multitheread on search
// views
// interface for user and admin
// have a static user in Signup

// issue interface  -> multiple types

//normalizedata, relational database




public class Issue {

    public static Integer nextid;
    public Integer id;
    public String summary;
    public String project;
    public String type;
    public String inrelease;
    public String description;
    public String importance;
    public static ArrayList<Issue> allIssues = new ArrayList<Issue>();


    public static void updateAllIssues() throws SQLException, ClassNotFoundException {

        if(allIssues.size()>0)
            allIssues.clear();
        allIssues.addAll(TableIssuesController.select("*"));
    }
    public Issue(Integer id, String summary, String project, String type, String inrelease, String description, String importance) {
        this.id = id;
        this.summary = summary;
        this.project = project;
        this.type = type;
        this.inrelease = inrelease;
        this.description = description;
        this.importance = importance;
    }

    public static int getnextid() throws SQLException, ClassNotFoundException {

        return TableIssuesController.getMAXId()+1;
    }

    @Override
    public String toString() {
        String allissueinfo = "";

        allissueinfo += "ID: " + this.id + "\n\n";

        allissueinfo += "Summary: " + this.summary + "\n\n";

        allissueinfo += "Project: " + this.project + "\n\n";

        allissueinfo += "Type: " + this.type + "\n\n";

        allissueinfo += "In release: " + this.inrelease + "\n\n";

        allissueinfo += "Description: " + this.description + "\n\n";

        allissueinfo += "Importance: " + this.importance + "\n\n";


        return allissueinfo;
    }
}

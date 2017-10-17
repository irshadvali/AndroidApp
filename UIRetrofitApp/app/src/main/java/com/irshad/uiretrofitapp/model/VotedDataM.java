package com.irshad.uiretrofitapp.model;

/**
 * Created by irshadvali on 14/01/17.
 */

public class VotedDataM {
    private Integer perc;
    private String option;
    private Integer perctwo;

    public VotedDataM() {
    }

    public VotedDataM(String option, Integer perc, Integer perctwo) {
        this.option = option;
        this.perc=perc;
        this.perctwo=perctwo;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }


    public Integer getPerc() {
        return perc;
    }

    public void setPerc(Integer perc) {
        this.perc = perc;
    }

    public Integer getPerctwo() {
        return perctwo;
    }

    public void setPerctwo(Integer perctwo) {
        this.perctwo = perctwo;
    }

}


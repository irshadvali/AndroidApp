package com.irshad.uiretrofitapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irshadvali on 27/11/16.
 */

public class NotificationModel {
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();
    @SerializedName("error")
    @Expose
    private Error error;

    /**
     *
     * @return
     *     The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     *     The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     *
     * @return
     *     The error
     */
    public Error getError() {
        return error;
    }

    /**
     *
     * @param error
     *     The error
     */
    public void setError(Error error) {
        this.error = error;
    }

    public class Result {

        @SerializedName("commentstype")
        @Expose
        private Integer commentstype;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("update")
        @Expose
        private String update;
        @SerializedName("commenttxt")
        @Expose
        private String commenttxt;

        /**
         *
         * @return
         *     The commentstype
         */
        public Integer getCommentstype() {
            return commentstype;
        }

        /**
         *
         * @param commentstype
         *     The commentstype
         */
        public void setCommentstype(Integer commentstype) {
            this.commentstype = commentstype;
        }

        /**
         *
         * @return
         *     The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         *     The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         *     The update
         */
        public String getUpdate() {
            return update;
        }

        /**
         *
         * @param update
         *     The update
         */
        public void setUpdate(String update) {
            this.update = update;
        }

        /**
         *
         * @return
         *     The commenttxt
         */
        public String getCommenttxt() {
            return commenttxt;
        }

        /**
         *
         * @param commenttxt
         *     The commenttxt
         */
        public void setCommenttxt(String commenttxt) {
            this.commenttxt = commenttxt;
        }

    }

    public class Error {

        @SerializedName("errCode")
        @Expose
        private Integer errCode;
        @SerializedName("errMsg")
        @Expose
        private String errMsg;

        /**
         *
         * @return
         *     The errCode
         */
        public Integer getErrCode() {
            return errCode;
        }

        /**
         *
         * @param errCode
         *     The errCode
         */
        public void setErrCode(Integer errCode) {
            this.errCode = errCode;
        }

        /**
         *
         * @return
         *     The errMsg
         */
        public String getErrMsg() {
            return errMsg;
        }

        /**
         *
         * @param errMsg
         *     The errMsg
         */
        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

    }

}

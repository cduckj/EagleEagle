package web.model;


import web.entities.Review;

public class ReviewModel extends Review{
   private int cmtcnt;

   public int getCmtcnt() {
      return cmtcnt;
   }

   public void setCmtcnt(int cmtcnt) {
      this.cmtcnt = cmtcnt;
   }
}

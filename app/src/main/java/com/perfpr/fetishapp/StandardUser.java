package com.perfpr.fetishapp;

/**
 * Created by Gmurray68w on 6/9/2017.
 */

public class StandardUser {
   private String mPathToPhoto;
   private String mFirstName;
   private String mLastName;
   private String mDob;
   private String mGender;
   private String mBio;
   private String mSexualOrientation;
   private String mKinks;
   private String mRejected;
   private String mUnmatched;
   private String mMatched;
   private String mEmail;
   private String mZipCode;
   private String mLastOnline;
   private Boolean isOnline;

   public StandardUser(String pathToPhoto, String mFirstName, String mLastName, String mDob, String mGender, String mBio, String mSexualOrientation, String mKinks, String mRejected, String mUnmatched, String mMatched, String mEmail, String mZipCode, String mLastOnline, Boolean isOnline) {
      this.mPathToPhoto = pathToPhoto;
      this.mFirstName = mFirstName;
      this.mLastName = mLastName;
      this.mDob = mDob;
      this.mGender = mGender;
      this.mBio = mBio;
      this.mSexualOrientation = mSexualOrientation;
      this.mKinks = mKinks;
      this.mRejected = mRejected;
      this.mUnmatched = mUnmatched;
      this.mMatched = mMatched;
      this.mEmail = mEmail;
      this.mZipCode = mZipCode;
      this.mLastOnline = mLastOnline;
      this.isOnline = isOnline;
   }
   public String getmPathToPhoto(){
      return mPathToPhoto;
   }
   public void setmPathToPhoto(){
      this.mPathToPhoto = mPathToPhoto;
   }

   public String getmFirstName() {
      return mFirstName;
   }

   public void setmFirstName(String mFirstName) {
      this.mFirstName = mFirstName;
   }

   public String getmLastName() {
      return mLastName;
   }

   public void setmLastName(String mLastName) {
      this.mLastName = mLastName;
   }

   public String getmDob() {
      return mDob;
   }

   public void setmDob(String mDob) {
      this.mDob = mDob;
   }

   public String getmGender() {
      return mGender;
   }

   public void setmGender(String mGender) {
      this.mGender = mGender;
   }

   public String getmBio() {
      return mBio;
   }

   public void setmBio(String mBio) {
      this.mBio = mBio;
   }

   public String getmSexualOrientation() {
      return mSexualOrientation;
   }

   public void setmSexualOrientation(String mSexualOrientation) {
      this.mSexualOrientation = mSexualOrientation;
   }

   public String getmKinks() {
      return mKinks;
   }

   public void setmKinks(String mKinks) {
      this.mKinks = mKinks;
   }

   public String getmRejected() {
      return mRejected;
   }

   public void setmRejected(String mRejected) {
      this.mRejected = mRejected;
   }

   public String getmUnmatched() {
      return mUnmatched;
   }

   public void setmUnmatched(String mUnmatched) {
      this.mUnmatched = mUnmatched;
   }

   public String getmMatched() {
      return mMatched;
   }

   public void setmMatched(String mMatched) {
      this.mMatched = mMatched;
   }

   public String getmEmail() {
      return mEmail;
   }

   public void setmEmail(String mEmail) {
      this.mEmail = mEmail;
   }

   public String getmZipCode() {
      return mZipCode;
   }

   public void setmZipCode(String mZipCode) {
      this.mZipCode = mZipCode;
   }

   public String getmLastOnline() {
      return mLastOnline;
   }

   public void setmLastOnline(String mLastOnline) {
      this.mLastOnline = mLastOnline;
   }

   public Boolean getOnline() {
      return isOnline;
   }

   public void setOnline(Boolean online) {
      isOnline = online;
   }
}

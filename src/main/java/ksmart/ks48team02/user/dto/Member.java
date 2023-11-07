package ksmart.ks48team02.user.dto;

public class Member {

    private String memberId;
    private String memberTypeCode;
    private String memberName;
    private String memberPw;
    private String memberRegDate;
    private String memberEmail;
    private String memberContactInfo;
    private String unRegDate;
    private String unRegStatus;


    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberTypeCode='" + memberTypeCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", memberRegDate='" + memberRegDate + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberContactInfo='" + memberContactInfo + '\'' +
                ", unRegDate='" + unRegDate + '\'' +
                ", unRegStatus='" + unRegStatus + '\'' +
                '}';
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberTypeCode() {
        return memberTypeCode;
    }

    public void setMemberTypeCode(String memberTypeCode) {
        this.memberTypeCode = memberTypeCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberRegDate() {
        return memberRegDate;
    }

    public void setMemberRegDate(String memberRegDate) {
        this.memberRegDate = memberRegDate;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberContactInfo() {
        return memberContactInfo;
    }

    public void setMemberContactInfo(String memberContactInfo) {
        this.memberContactInfo = memberContactInfo;
    }

    public String getUnRegDate() {
        return unRegDate;
    }

    public void setUnRegDate(String unRegDate) {
        this.unRegDate = unRegDate;
    }

    public String getUnRegStatus() {
        return unRegStatus;
    }

    public void setUnRegStatus(String unRegStatus) {
        this.unRegStatus = unRegStatus;
    }
}

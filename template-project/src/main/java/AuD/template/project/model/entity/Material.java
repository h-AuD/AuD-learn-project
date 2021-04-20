package AuD.template.project.model.entity;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * 微信媒体素材信息
 *
 * @author AuD/胡钊
 * @version 1.0
 * @date 2021/1/7 17:42
 * @Version 1.0
 */
public class Material {
    private Integer id;
    private String mediaId;
    private String title;
    private Integer seq;
    private String thumbMediaId;
    private String author;
    private String digest;
    private String mediaType;
    private Integer showCoverPic;
    private String context;
    private String url;
    private String sourceUrl;
    private String updateTime;
    private LocalDateTime createTime;


    /**
     * 重写该方法 === 用于判断数据内容是否一致
     * @return
     */
    @Override
    public String toString() {
        return "Material{" +
                "mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", seq=" + seq +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", author='" + author + '\'' +
                ", digest='" + digest + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", showCoverPic=" + showCoverPic +
                ", context='" + context + '\'' +
                ", url='" + url + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                '}';
    }

    /* 用于判断数据内容是否一致 */
    /* 假如:只有一个属性是不一致,进行的更新的时候,如何定位到该属性,而不是更新所有 === 问题点:更新一个字段和更新多个字段的优化性 */
    public boolean ContentIsEqual(Material others){
        if(others==null) return false;
        return this.toString().equals(others.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(Integer showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}

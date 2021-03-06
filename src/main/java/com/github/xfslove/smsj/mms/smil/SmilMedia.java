package com.github.xfslove.smsj.mms.smil;

import java.io.Serializable;

/**
 * @author hanwen
 * created at 2018/8/23.
 */
public interface SmilMedia extends Serializable {

  String getSrc();

  /**
   * @return reference SmilRegion
   */
  String getRef();


  class Image implements SmilMedia {

    private final String src;

    private String ref;

    public Image(String src) {
      this.src = src;
    }

    public void setRef(String ref) {
      this.ref = ref;
    }

    @Override
    public String getSrc() {
      return src;
    }

    @Override
    public String getRef() {
      return ref;
    }
  }

  class Audio implements SmilMedia {

    private final String src;

    private String ref;

    public Audio(String src) {
      this.src = src;
    }

    public void setRef(String ref) {
      this.ref = ref;
    }

    @Override
    public String getSrc() {
      return src;
    }

    @Override
    public String getRef() {
      return ref;
    }
  }

  class Video implements SmilMedia {

    private final String src;

    private String ref;

    public Video(String src) {
      this.src = src;
    }

    public void setRef(String ref) {
      this.ref = ref;
    }

    @Override
    public String getSrc() {
      return src;
    }

    @Override
    public String getRef() {
      return ref;
    }
  }

  class Text implements SmilMedia {

    private final String src;

    private String ref;

    public Text(String src) {
      this.src = src;
    }

    public void setRef(String ref) {
      this.ref = ref;
    }

    @Override
    public String getSrc() {
      return src;
    }

    @Override
    public String getRef() {
      return ref;
    }
  }
}

package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 22/02/2018.
 */
public class Student {
  private String name;
  private Integer grade;
  private String code;
  private Double avgScore;

  public Student(String name, Integer grade, String code, Double avgScore) {
    this.name = name;
    this.grade = grade;
    this.code = code;
    this.avgScore = avgScore;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", grade=" + grade +
        ", code='" + code + '\'' +
        ", avgScore=" + avgScore +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Double getAvgScore() {
    return avgScore;
  }

  public void setAvgScore(Double avgScore) {
    this.avgScore = avgScore;
  }
}

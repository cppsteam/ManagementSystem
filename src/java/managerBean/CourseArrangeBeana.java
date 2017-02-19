/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import dao.*;
import entites.*;
import java.util.*;
import javax.faces.bean.*;

/**
 *
 * @author 0576
 */
@ManagedBean
@SessionScoped
public class CourseArrangeBeana {

    private String courseType;

    private List<CourseArrange> courseArranges;

    public CourseArrangeBeana() {
    }

    public void autoArrange() {
        CourseArrange courseArrange;
        List<String> teacherTime;
        List<TeacherArrange> teacherArranges;
        Teacher teacher;
        Course course;
        int[] weekAndLessons;
        String weeks, time;
        int randomLesson;
        Classroom classroom;
        for (int i = 0; i < courseArranges.size(); i++) {
            courseArrange = courseArranges.get(i);
            course = courseArrange.getTeacherArrange().getCourse();
            teacher = courseArrange.getTeacherArrange().getTeacher();
            teacherArranges = (List) teacher.getTeacherArranges();
            teacherTime = new ArrayList<>();
            for (int j = 0; j < teacherArranges.size(); j++) {//得到该老师的已安排时间
                teacherTime.add(teacherArranges.get(j).getCourseArrange().getClassTime());
            }
            weekAndLessons = weekAndLessonCount(course.getTotalHour());
            if (weekAndLessons[2] == 1) {
                switch (weekAndLessons[0]) {
                    case 16:
                        weeks = "1-16周";
                        break;
                    case 8:
                        weeks = "1-8周";
                        break;
                    case 10:
                        weeks = "1-10周";
                        break;
                }
                do {
                    randomLesson = randomLesson(weekAndLessons[1]);
                    time = "星期" + randomWeek() + " " + randomLesson + "-" + add(randomLesson, weekAndLessons[1]) + "节";
                } while (ifTeacherTimeContains(teacherTime, time));
            } else {
                weeks = "1-16周";
                String randomWeek = null;
                do {
                    randomWeek = randomWeek();
                    randomLesson = randomLesson(weekAndLessons[1]);
                    time = "星期" + randomWeek + " " + randomLesson + "-" + add(randomLesson, weekAndLessons[1]) + "节";
                } while (ifTeacherTimeContains(teacherTime, time));
                String time2 = null;
                do {
                    String randomWeek2 = randomWeek();
                    if (randomWeek2.equals(randomWeek)) {
                        randomWeek2 = randomWeek();
                    }
                    randomLesson = randomLesson(weekAndLessons[1]);
                    time2 = "星期" + randomWeek2 + " " + randomLesson + "-" + add(randomLesson, weekAndLessons[1]) + "节";
                } while (ifTime2EqualsTime(time, time2));
                time = time + "/" + time2;
            }
            classroom = randomClassroom(time);
            courseArrange.setClassroom(classroom);
            courseArrange.setClassTime(time);
            CourseArrangeDAO.updateCourseArrange(courseArrange);
        }
    }

    private Classroom randomClassroom(String time) {
        List<CourseArrange> courArranges = CourseArrangeDAO.findAllArranges();//得到所有教室的已安排时间
        List<Classroom> classrooms = ClassroomDAO.findAllClassroom();
        for (int i = 0; i < courseArranges.size(); i++) {
            if (courseArranges.get(i).getClassTime().equals(time)) {
                classrooms.remove(courseArranges.get(i).getClassroom());
            }
        }
        Random random = new Random();
        int index = random.nextInt(classrooms.size()) + 1;
        return classrooms.get(index - 1);
    }

    public boolean ifTeacherTimeContains(List<String> teacherTime, String time) {
        if (teacherTime.contains(time)) {
            return true;
        }
        for (int i = 0; i < teacherTime.size(); i++) {
            String teaTime = teacherTime.get(i);
            if (teaTime.substring(0, 3).equals(time.substring(0, 3))) {
                if (teaTime.substring(6, 7).equals(time.substring(4, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifTime2EqualsTime(String time, String time2) {
        if (time2.equals(time)) {
            return true;
        } else if (time.substring(0, 3).equals(time2.substring(0, 3))) {
            if (time.substring(6, 7).equals(time2.substring(4, 5))) {
                return true;
            }
        }
        return false;
    }

    private int add(int a, int b) {
        return a + b - 1;
    }

    private String randomWeek() {
        String[] weeks = new String[]{"一", "二", "三", "四", "五"};
        Random random = new Random();
        int index = random.nextInt(weeks.length - 1);
        return weeks[index];
    }

    private int randomLesson(int count) {
        ArrayList<Integer> lesson = new ArrayList<>();
        lesson.add(1);
        lesson.add(3);
        lesson.add(4);
        lesson.add(6);
        lesson.add(8);
        lesson.add(9);
        if (count == 3) {
            lesson.remove(2);
            lesson.remove(4);
        }
        Random random = new Random();
        int index = random.nextInt(lesson.size() - 1);
        return lesson.get(index);
    }

    private int[] weekAndLessonCount(int hour) {
        int[] weekAndLesson = new int[3];
        switch (hour) {
            case 48:
            case 32:
                weekAndLesson[0] = 16;//周次
                weekAndLesson[1] = hour / 16;//一次几节课
                weekAndLesson[2] = 1;//一周几次课
                break;
            case 64:
            case 96:
                weekAndLesson[0] = 16;
                weekAndLesson[1] = hour / 32;
                weekAndLesson[2] = 2;
                break;
            case 16:
                weekAndLesson[0] = 8;
                weekAndLesson[1] = 2;
                weekAndLesson[2] = 1;
                break;
            case 20:
                weekAndLesson[0] = 10;
                weekAndLesson[1] = 2;
                weekAndLesson[2] = 1;
                break;
        }
        return weekAndLesson;
    }

    public String getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    /**
     * @return the courseArranges
     */
    public List<CourseArrange> getCourseArranges() {
        return courseArranges;
    }

    public void setCourseArranges() {
        courseArranges = new ArrayList<>();
        List<TeacherArrange> teacherArranges = TeacherArrangeDAO.findTeacherArrangesByType(courseType);
        for (int i = 0; i < teacherArranges.size(); i++) {
            courseArranges.add(teacherArranges.get(i).getCourseArrange());
        }

    }

}

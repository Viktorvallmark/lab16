package org.example;

/** Faculty */
public class Faculty {

  private Program[] programs;
  private Teacher[] teachers;
  private String facultyName;
  private int programIndex;

  public Faculty(String facultyName, int amountOfPrograms, int amountOfTeachers) {

    if (!facultyName.isEmpty() || !facultyName.isBlank()) {
      this.facultyName = facultyName;
    }
    if ((amountOfPrograms > 0) && (amountOfTeachers > 0)) {
      this.programs = new Program[amountOfPrograms];
      this.teachers = new Teacher[amountOfTeachers];
    }
    if ((amountOfPrograms > 0)) {
      this.programIndex = programs.length;
    }
  }

  private int getProgramIndex(String programName) {

    for (int i = 0; i < programs.length; i++) {
      if (programs[i].getProgramName() == programName) {
        programIndex = i;
        return i;
      } else {
        return -1;
      }
    }
    return -1;
  }

  public String removeStudentFromProgram(String studentName, String programName) {
    for (Program program : programs) {
      if (program.getProgramName() == programName) {
        for (Student student : program.getStudents()) {
          if (student.getName() == studentName) {
            Student temp = student;
            student = null;
            return "Student: " + temp.getName() + " has been removed from program: " + programName;
          }
        }
      }
    }
    return "-1";
  }

  public String checkIfTeacherExists(String teacherName) {
    for (Teacher teacher : teachers) {
      if (teacher.toString() == teacherName) {
        return "Teacher: " + teacher.toString() + " exists.";
      }
    }
    return "Couldn't find teacher with that name";
  }

  public String addCoursesToProgram(Course[] courses, String programName) {
    for (Program program : programs) {
      if (program.getProgramName() == programName) {
        program.setCourses(courses);
        return "Added courses to program: " + programName;
      }
    }
    return "-1";
  }

  public String getFacultyName() {
    return this.facultyName;
  }

  public String addStudentToProgram(String programName, String studentName) {

    for (Program program : programs) {
      if (program.getProgramName() == programName) {
        program.addStudent(program.createStudent(studentName, studentName));

        return "Student: " + studentName + " added to program: " + programName;
      }
    }
    return "Couldn't add student to program";
  }

  public String addProgram(String programName, int amountOfCourses, int amountOfStudents) {

    for (int i = 0; i < programs.length; i++) {
      if (programs[i] == null) {
        programs[i] = new Program(programName, amountOfCourses, amountOfStudents);
        return "Program: "
            + programName
            + " with "
            + amountOfCourses
            + " courses and "
            + amountOfStudents
            + " students has been created.";
      }
    }

    return "Couldn't add new program";
  }

  public String[] getProgramNames() {
    String[] temp = new String[programs.length];

    for (int i = 0; i < programs.length; i++) {
      temp[i] = programs[i].getProgramName();
    }
    return temp;
  }

  public String findStudent(String studentName, String programName) {
    for (Program program : programs) {
      if (program.getProgramName() == programName) {
        for (Student student : program.getStudents()) {
          if (student.getName() == studentName) {
            return "Found student: " + studentName + " in " + "program: " + programName;
          }
        }
      }
    }
    return "Couldn't find student in program";
  }

  // TODO: Make same as addProgram();
  public String addTeachersToFaculty(Teacher[] teachers) {
    return "";
  }

  public String findStudentById(String uniID, String programName) {
    for (Program program : programs) {
      if (program.getProgramName() == programName) {
        for (Student student : program.getStudents()) {
          if (student.getUni_ID() == uniID) {

            return "Found student: "
                + student.getName()
                + " in "
                + "program: "
                + programName
                + " with ID: "
                + uniID;
          }
        }
      }
    }
    return "Couldn't find student by uni ID.";
  }
}

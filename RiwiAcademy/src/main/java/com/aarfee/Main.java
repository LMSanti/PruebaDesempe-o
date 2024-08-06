package com.aarfee;

import com.aarfee.controller.CourseController;
import com.aarfee.controller.InscriptionController;
import com.aarfee.controller.RatingController;
import com.aarfee.controller.StudentController;
import com.aarfee.entities.CourseEntity;
import com.aarfee.entities.InscriptionEntity;
import com.aarfee.entities.RatingEntity;
import com.aarfee.entities.StudentEntity;
import com.aarfee.utils.enums.ActiveEnum;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    boolean exit = false;
        JOptionPane.showMessageDialog(null,"Bienvenido al administrador academico de riwi.");
    do {
        String option = JOptionPane.showInputDialog("Ingrese la opcion que desea realizar: " +
                "\n1. Para administrar cursos. " +
                "\n 2. Para administrar Estudientes. " +
                "\n 3. Para administrar inscripciones. " +
                "\n 4. Para administrar calificaiones.  " +
                "\n 0. Para salir.");
        switch (option){
            case "1":
                boolean exitCourse = false;
                do {
                    CourseController courseController = new CourseController();
                    String optionCourse = JOptionPane.showInputDialog("ADMINISTRADOR DE CURSOS. " +
                            "\n ¿elija la opcion que desea realizar. " +
                            "\n 1. Para crear un curso." +
                            "\n 2. Para ver todos los cursos. " +
                            "\n 3. Para buscar un curso por id. " +
                            "\n 4. Para actulizar un curso. " +
                            "\n 5. para eliminar un curso. " +
                            "\n 6. Para salir");
                    switch (optionCourse){
                        case "1":
                            String name = JOptionPane.showInputDialog("Ingrese el nombre del curso: ");
                            CourseEntity course = new CourseEntity(name);
                            CourseEntity courseInput = courseController.create(course);

                            JOptionPane.showMessageDialog(null, courseInput.toString());
                            break;
                        case "2":
                            ArrayList<CourseEntity> courses = courseController.readAll();
                            JOptionPane.showMessageDialog(null, courses.toString());
                            break;
                        case "3":
                            String cId = JOptionPane.showInputDialog("Ingrese el id del curso que desea ver: ");
                            CourseEntity courseId = courseController.readById(Integer.parseInt(cId));

                            JOptionPane.showMessageDialog(null, courseId.toString());
                            break;
                        case "4":
                            String eId = JOptionPane.showInputDialog("Ingrese el id del curso que desea editar: ");
                            String eName = JOptionPane.showInputDialog("Ingrese el nuevo nombre del curso: ");

                            CourseEntity courseEdit = new CourseEntity(eName);
                            CourseEntity courseFinal = courseController.upDate(courseEdit, Integer.parseInt(eId));
                            JOptionPane.showMessageDialog(null, courseFinal.toString());
                            break;
                        case "5":
                            String dId = JOptionPane.showInputDialog("Ingrese el id del curson que desea eliminar: ");
                            boolean deleteCourse = courseController.delete(Integer.parseInt(dId));
                            JOptionPane.showMessageDialog(null, deleteCourse);
                            break;
                        case "6":
                            exitCourse = true;
                            JOptionPane.showMessageDialog(null, "Saliendo del administrador de cursos.");
                            break;
                    }
                }while (!exitCourse);
                break;
            case "2":
                boolean exitStudent = false;
                do {
                    StudentController studentController = new StudentController();
                    String optionStudent = JOptionPane.showInputDialog("ADMINISTRADOR DE ESTUDIANTES. " +
                            "\n ¿elija la opcion que desea realizar. " +
                            "\n 1. Para crear un estudiante." +
                            "\n 2. Para ver todos los estudiantes. " +
                            "\n 3. Para buscar un estudiante por id. " +
                            "\n 4. Para buscar un curso por email. " +
                            "\n 5. Para actualizar un estudiante" +
                            "\n 6. Para salir");
                    switch (optionStudent){
                        case "1":
                            String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
                            String last_name = JOptionPane.showInputDialog("Ingrese el apellido del estudiante: ");
                            String document = JOptionPane.showInputDialog("Ingrese el documento del estudiante: ");
                            String email = JOptionPane.showInputDialog("Ingrese el correo del estudiante: ");
                            ActiveEnum status = ActiveEnum.valueOf(JOptionPane.showInputDialog("Ingrese el estado del estudiante: "));

                            StudentEntity student = new StudentEntity(name, last_name,document,email,status);
                            StudentEntity studentInput = studentController.create(student);

                            JOptionPane.showMessageDialog(null, studentInput.toString());
                            break;
                        case "2":
                            ArrayList<StudentEntity> students = studentController.readAll();
                            JOptionPane.showMessageDialog(null, students.toString());
                            break;
                        case "3":
                            String sId = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea ver: ");
                            StudentEntity studentId = studentController.readById(Integer.parseInt(sId));

                            JOptionPane.showMessageDialog(null, studentId.toString());
                            break;
                        case "4":
                            String sEmail = JOptionPane.showInputDialog("Ingrese el email del estudiante que desea ver: ");
                            StudentEntity studentEmail = studentController.readByEmail(sEmail);

                            JOptionPane.showMessageDialog(null, studentEmail.toString());
                            break;
                        case "5":
                            String eId = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea editar: ");
                            String eName = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
                            String eLastName = JOptionPane.showInputDialog("Ingrese el apellido del estudiante: ");
                            String eDocument = JOptionPane.showInputDialog("Ingrese el documento del estudiante: ");
                            String eEmail = JOptionPane.showInputDialog("Ingrese el correo del estudiante: ");
                            ActiveEnum eStatus = ActiveEnum.valueOf(JOptionPane.showInputDialog("Ingrese el estado del estudiante: "));

                            StudentEntity studentEdit = new StudentEntity(eName,eLastName,eDocument,eEmail,eStatus);
                            StudentEntity studentFinal = studentController.upDate(studentEdit, Integer.parseInt(eId));
                            JOptionPane.showMessageDialog(null, studentFinal.toString());
                            break;
                        case "6":
                            exitStudent = true;
                            JOptionPane.showMessageDialog(null, "Saliendo del administrador de estudiantes.");
                            break;
                    }
                }while (!exitStudent);
                break;
            case "3":
                boolean exitInscription = false;
                do {
                    InscriptionController inscriptionController = new InscriptionController();
                    String optionInscription = JOptionPane.showInputDialog("ADMINISTRADOR DE INSCRIPCIONES. " +
                            "\n ¿elija la opcion que desea realizar. " +
                            "\n 1. Para crear una inscripcion." +
                            "\n 2. Para ver todas las inscripciones. " +
                            "\n 3. Para buscar una inscripcion por id. " +
                            "\n 4. Para actualizar una inscripcion. " +
                            "\n 5. Para eliminar una inscripcion. " +
                            "\n 6. Para salir");
                    switch (optionInscription){
                        case "1":
                            int id_course = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso: "));
                            int id_student = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del estudiante: "));

                            InscriptionEntity inscription = new InscriptionEntity(id_course,id_student);
                            InscriptionEntity inscriptionInput = inscriptionController.create(inscription);

                            JOptionPane.showMessageDialog(null, inscriptionInput.toString());
                            break;
                        case "2":
                            ArrayList<InscriptionEntity> inscriptions = inscriptionController.readAll();
                            JOptionPane.showMessageDialog(null, inscriptions.toString());
                            break;
                        case "3":
                            String sId = JOptionPane.showInputDialog("Ingrese el id de la incripcion que desea ver: ");
                            InscriptionEntity inscriptionId = inscriptionController.readById(Integer.parseInt(sId));

                            JOptionPane.showMessageDialog(null, inscriptionId.toString());
                            break;
                        case "4":
                            int eId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la inscripcion que desea editar: "));
                            int id_courseN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso: "));
                            int id_studentN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del estudiante: "));


                            InscriptionEntity inscriptionEdit = new InscriptionEntity(id_courseN, id_studentN);
                            InscriptionEntity inscrptionFinal = inscriptionController.upDate(inscriptionEdit, eId);
                            JOptionPane.showMessageDialog(null, inscrptionFinal.toString());
                            break;
                        case "5":
                            String dId = JOptionPane.showInputDialog("Ingrese el id de la inscripcion que desea eliminar: ");
                            boolean deleteInscription = inscriptionController.delete(Integer.parseInt(dId));
                            JOptionPane.showMessageDialog(null, deleteInscription);
                            break;
                        case "6":
                            exitInscription = true;
                            JOptionPane.showMessageDialog(null, "Saliendo del administrador de Inscripciones.");
                            break;
                    }
                }while (!exitInscription);
                break;
            case "4":
                boolean exitRating = false;
                do {
                    RatingController ratingController = new RatingController();
                    String optionRating = JOptionPane.showInputDialog("ADMINISTRADOR DE CALIFICACIONES. " +
                            "\n ¿elija la opcion que desea realizar. " +
                            "\n 1. Para crear una nueva calificacion." +
                            "\n 2. Para ver todas las calificaciones. " +
                            "\n 3. Para buscar una calificacion por id. " +
                            "\n 4. Para actualizar una calificacion. " +
                            "\n 5. Para salir");
                    switch (optionRating){
                        case "1":
                            String description = JOptionPane.showInputDialog("Ingrese la descripcion de la calificacion: ");
                            int ratingV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la calificacion: "));
                            int id_inscription = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la inscripcion: "));

                            RatingEntity rating = new RatingEntity(description,ratingV,id_inscription);
                            RatingEntity ratingInput = ratingController.create(rating);

                            JOptionPane.showMessageDialog(null, ratingInput.toString());
                            break;
                        case "2":
                            ArrayList<RatingEntity> ratings = ratingController.readAll();
                            JOptionPane.showMessageDialog(null, ratings.toString());
                            break;
                        case "3":
                            int sId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la Calificacion que desea ver: "));
                            RatingEntity ratingId = ratingController.readByid(sId);

                            JOptionPane.showMessageDialog(null, ratingId.toString());
                            break;
                        case "4":
                            int eId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la calificacion que desea editar: "));
                            String descriptionN = JOptionPane.showInputDialog("Ingrese la descripcion de la calificacion: ");
                            int ratingN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la calificacion: "));
                            int id_inscriptionN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la inscripcion: "));

                            RatingEntity ratingEdit = new RatingEntity(descriptionN,ratingN,id_inscriptionN);
                            RatingEntity ratingFinal = ratingController.upDate(ratingEdit, eId);
                            JOptionPane.showMessageDialog(null, ratingFinal.toString());
                            break;
                        case "5":
                            exitRating = true;
                            JOptionPane.showMessageDialog(null, "Saliendo del administrador de Calificaciones.");
                            break;

                    }
                }while (!exitRating);
                break;
            case "5":
                exit = true;
                JOptionPane.showMessageDialog(null, "Hasta pronto");
                break;
        }

    } while (!exit);
    }

}
package com.knu.daeguhackathon.global.utils;

import com.knu.daeguhackathon.global.utils.course.Course;
import com.knu.daeguhackathon.global.utils.course.repository.CourseRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public DataLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Value("${csv.file.path}")
    private String csvFilePath;


    @Override
    public void run(String... args) {
        importCsv(csvFilePath);  // CSV 파일 경로
    }

    private void importCsv(String filePath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            csvReader.readNext();
            csvReader.readNext();
            csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null) {
                if(!nextLine[8].contains("상주캠퍼스")){// 강좌번호
                    Course course = new Course();
                    course.setCourseId(nextLine[0]);
                    course.setCourseName(nextLine[4]);    // 교과목명
                    course.setType(nextLine[6]);           // 구분
                    course.setLectureTime(nextLine[7]);    // 강의시간
                    course.setClassroom(nextLine[8]);      // 강의실
                    courseRepository.save(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

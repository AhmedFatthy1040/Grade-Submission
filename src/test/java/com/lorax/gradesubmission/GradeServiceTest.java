package com.lorax.gradesubmission;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.lorax.gradesubmission.repository.GradeRepository;
import com.lorax.gradesubmission.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest() {
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            new Grade("Ahmed", "Machine Learning", "B+"),
            new Grade("Muhammed", "Math", "C")
        ));

        List<Grade> result = gradeService.getGrades();

        assertEquals("Ahmed", result.get(0).getName());
        assertEquals("Math", result.get(1).getSubject());
    }

    @Test
    public void getGradeIndexTest() {
        Grade grade_1 = new Grade("Ahmed", "Machine Learning", "B+");
        Grade grade_2 = new Grade("Muhammed", "Math", "C");


        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            grade_1,
            grade_2
        ));
        when(gradeRepository.getGrade(0)).thenReturn(grade_1);
        when(gradeRepository.getGrade(1)).thenReturn(grade_2);

        List<Grade> result = gradeService.getGrades();
        int valid = gradeService.getGradeIndex(result.get(1).getId());
        int notFound = gradeService.getGradeIndex("926753");

        assertEquals(1, valid);
        assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void getGradeByIdTest() {
        Grade grade_1 = new Grade("Ahmed", "Machine Learning", "B+");
        Grade grade_2 = new Grade("Muhammed", "Math", "C");


        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            grade_1,
            grade_2
        ));
        when(gradeRepository.getGrade(0)).thenReturn(grade_1);
        when(gradeRepository.getGrade(1)).thenReturn(grade_2);

        String id = grade_1.getId();
        Grade result = gradeService.getGradeById(id);

        assertEquals(grade_1, result);
    }

    @Test
    public void addGradeTest() {
        Grade grade_1 = new Grade("Ahmed", "Machine Learning", "B+");
        Grade grade_2 = new Grade("Muhammed", "Math", "C");

        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade_1,grade_2));
        when(gradeRepository.getGrade(0)).thenReturn(grade_1);
        when(gradeRepository.getGrade(1)).thenReturn(grade_2);

        Grade newGrade = new Grade("Lorax", "Programming", "A+");
        gradeService.submitGrade(newGrade);

        verify(gradeRepository, times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest() {
        Grade grade_1 = new Grade("Ahmed", "Machine Learning", "B+");
        Grade grade_2 = new Grade("Muhammed", "Math", "C");

        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade_1,grade_2));
        when(gradeRepository.getGrade(0)).thenReturn(grade_1);
        when(gradeRepository.getGrade(1)).thenReturn(grade_2);

        grade_2.setName("Lorax");
        gradeService.submitGrade(grade_2);

        verify(gradeRepository, times(1)).updateGrade(grade_2, 1);
    }
}
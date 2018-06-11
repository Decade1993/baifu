package com.baifu.erp.validator;

import com.baifu.erp.criteria.DepartmentCriteria;
import com.baifu.erp.dao.DepartmentDao;
import com.baifu.erp.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证部门不存在
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NotExistDepartmentName.NotExistDepartmentNameValidator.class})
public @interface NotExistDepartmentName {

  String message() default "该部门已存在";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class NotExistDepartmentNameValidator implements ConstraintValidator<NotExistDepartmentName, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      DepartmentCriteria departmentCriteria = new DepartmentCriteria();
      departmentCriteria.setName(value);
      List<Department> list = departmentDao.list(departmentCriteria);
      return list.size() == 0;
    }

    @Autowired
    DepartmentDao departmentDao;
  }
}

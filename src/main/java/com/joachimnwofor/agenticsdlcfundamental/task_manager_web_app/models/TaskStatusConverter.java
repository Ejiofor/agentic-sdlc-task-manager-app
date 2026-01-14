package com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TaskStatus attribute) {
        return attribute == null ? 0 : attribute.ordinal();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return TaskStatus.TODO;
        }
        TaskStatus[] values = TaskStatus.values();
        if (dbData < 0 || dbData >= values.length) {
            // Log / fallback to default to avoid exceptions when DB has unexpected values
            return TaskStatus.TODO;
        }
        return values[dbData];
    }
}

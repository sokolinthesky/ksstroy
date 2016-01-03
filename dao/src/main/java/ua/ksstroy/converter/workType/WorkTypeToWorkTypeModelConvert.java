package ua.ksstroy.converter.workType;


import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.workType.WorkType;
import ua.ksstroy.models.worktype.WorkTypeModel;

public class WorkTypeToWorkTypeModelConvert implements Converter<WorkType, WorkTypeModel> {

    public WorkTypeModel convert(WorkType workType) {
        WorkTypeModel model = new WorkTypeModel();

        model.setId(workType.getId());
        model.setName(workType.getName());
        model.setUnitPrice(workType.getUnitPrice());
        model.setMeasureName(workType.getMeasure());
        model.setDescription(workType.getDescription());

        return model;

    }
}

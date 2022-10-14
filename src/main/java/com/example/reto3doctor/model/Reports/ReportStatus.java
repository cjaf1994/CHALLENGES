package com.example.reto3doctor.model.Reports;


import com.example.reto3doctor.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportStatus {

    private Integer completed;
    private Integer cancelled;

}

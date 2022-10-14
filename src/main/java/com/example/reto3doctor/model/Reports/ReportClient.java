package com.example.reto3doctor.model.Reports;


import com.example.reto3doctor.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportClient {

    private Long total;
    private ClientModel client;

}

package com.MdgCorp.RestWebService.controller;

import com.MdgCorp.RestWebService.entity.Contract;
import com.MdgCorp.RestWebService.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class ContractListController {

    private final ContractService contractService;

    public ContractListController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/view/contracts")
    @ResponseStatus(HttpStatus.OK)
    public String ViewListOfContracts() {

        StringBuilder html = new StringBuilder();

        html.append("<html>")
                .append("<a href='/'><-- Back</a>")
                .append("<h1 style=\"text-align: center;\">List Of Contracts</h1>")
                .append("<body>")
                .append("<ul>");

        for (Contract contract : contractService.getContracts()) {
            html.append("<li>")
                    .append("<a href='/view/contracts/")
                    .append(contract.getId())
                    .append("'>")
                    .append("Contract ")
                    .append(contract.getId())
                    .append("</a>")
                    .append("</li>");
        }

        html.append("</ul>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }

    @GetMapping("/view/contracts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String Print(@PathVariable("id") Long id) throws Exception {

        Contract contractFound = new Contract();

        for (Contract contract : contractService.getContracts()) {
            if (Objects.equals(contract.getId(), id)) {
                contractFound = contract;
            }
        }

        return "<html>" +
                "<body>" +
                "<a href='/view/contracts'><-- Back</a>" +
                "<h1>Contract " + contractFound.getId() + "</h1>" +
                "<p>Person : " + contractFound.getPerson().getName() + "</p>" +
                "<p>Car : " + contractFound.getCar().getPlateNumber() + "</p>" +
                "<p>Start date : " + contractFound.getStartDate() + "</p>" +
                "<p>End date : " + contractFound.getEndDate() + "</p>" +
                "</body>" +
                "</html>";
    }
}
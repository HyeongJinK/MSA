package com.illunex.invest.api.core.InvestorRelations.controller;

        import com.illunex.invest.api.core.InvestorRelations.dto.CompanyInfoDTO;
        import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
        import io.swagger.annotations.Api;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestParam;

@Api(produces = "produces Value")
public interface InvestorRelationsController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = InvestorRelationsController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })

    ResponseEntity<CompanyInfoDTO> getBasicInfo(@RequestParam Long companyIdx, @RequestParam String year);

    ResponseEntity<CompanyInfoDTO> addBasicInfo(@RequestBody BasicInfoDTO basicInfoDTO);
}

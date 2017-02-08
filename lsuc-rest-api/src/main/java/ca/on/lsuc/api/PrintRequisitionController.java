package ca.on.lsuc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.on.lsuc.jpa.entity.PrintRequisition;
import ca.on.lsuc.service.PrintRequisitionService;

@RestController
@RequestMapping(path = "/printRequisitions", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrintRequisitionController {

	@Autowired
	private PrintRequisitionService printRequisitionService;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public List<PrintRequisition> getPrintRequisitions() {
		return printRequisitionService.findAll();
	}
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    public PrintRequisition getPrintRequisition(@PathVariable("id") Long id) {
        return printRequisitionService.findPrintRequisition(id);
    }
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public PrintRequisition createPrintRequisition(@RequestBody PrintRequisition printRequisition) {
        return printRequisitionService.savePrintRequisition(printRequisition);
    }
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
    public PrintRequisition updatePrintRequisition(@PathVariable("id") Long id, @RequestBody PrintRequisition printRequisition) {
        return printRequisitionService.savePrintRequisition(printRequisition);
    }
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrintRequisition(@PathVariable("id") Long id) {
		printRequisitionService.deletePrintRequisition(id);
    }
}

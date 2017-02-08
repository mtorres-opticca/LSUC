package ca.on.lsuc.service;

import java.util.List;

import ca.on.lsuc.jpa.entity.PrintRequisition;

public interface PrintRequisitionService {

	PrintRequisition findPrintRequisition(Long id);

	List<PrintRequisition> findAll();

	PrintRequisition savePrintRequisition(PrintRequisition printRequisition);

	List<PrintRequisition> savePrintRequisitions(List<PrintRequisition> printRequisitions);

	void deletePrintRequisition(Long id);

	void deletePrintRequisition(PrintRequisition printRequisition);

	void deletePrintRequisitions(List<PrintRequisition> printRequisitions);	
}

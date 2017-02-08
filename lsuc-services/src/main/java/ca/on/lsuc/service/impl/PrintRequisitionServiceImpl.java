package ca.on.lsuc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ca.on.lsuc.jpa.dao.PrintRequisitionRepository;
import ca.on.lsuc.jpa.entity.PrintRequisition;
import ca.on.lsuc.service.PrintRequisitionService;

@Service
public class PrintRequisitionServiceImpl implements PrintRequisitionService {

	@Resource
	private PrintRequisitionRepository printRequisitionRepository;
	
	@Override
	public PrintRequisition findPrintRequisition(Long id) {
		return printRequisitionRepository.findOne(id);
	}
	
	@Override
	public List<PrintRequisition> findAll() {
		return printRequisitionRepository.findAll();
	}
	
	@Override
	public PrintRequisition savePrintRequisition(PrintRequisition printRequisition) {
		return printRequisitionRepository.save(printRequisition);
	}
	
	@Override
	public List<PrintRequisition> savePrintRequisitions(List<PrintRequisition> printRequisitions) {
		return printRequisitionRepository.save(printRequisitions);
	}
	
	@Override
	public void deletePrintRequisition(Long id) {
		printRequisitionRepository.delete(id);
	}
	
	@Override
	public void deletePrintRequisition(PrintRequisition printRequisition) {
		printRequisitionRepository.delete(printRequisition);
	}
	
	@Override
	public void deletePrintRequisitions(List<PrintRequisition> printRequisitions) {
		printRequisitionRepository.deleteInBatch(printRequisitions);
	}
}

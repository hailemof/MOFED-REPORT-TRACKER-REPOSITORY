package net.mofed.reportracking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mofed.reportracking.app.model.Penalty;
import net.mofed.reportracking.app.repository.PenaltyRepository;


@Service
public class PenaltyService {
	@Autowired
	private PenaltyRepository penaltyRepository;
	
	//Return list of penalty
	public List<Penalty>  getAllPenalty() {
		
		return penaltyRepository.findAll();
	}

	public void save(Penalty penalty) {
		// save penalty
		penaltyRepository.save(penalty);
	}
	
	//get by id
		public Optional<Penalty> findById(Integer id) {
			return penaltyRepository.findById(id);
		}

		public void delete(Integer id) {
			// delete penalty rule by id
			penaltyRepository.deleteById(id);
			
		}

	
}

package net.kepco.srm.bond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.kepco.srm.bond.domain.Sample;

@Repository("sampleRepository")
public interface SampleRepository extends JpaRepository<Sample, String> {
	
}

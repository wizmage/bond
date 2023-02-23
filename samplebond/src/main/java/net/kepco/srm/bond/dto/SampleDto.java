package net.kepco.srm.bond.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.kepco.srm.bond.domain.Sample;

@ToString
@Getter
@Setter
@Builder
public class SampleDto {

	private String id;
	private String name;
	private String description;
	private String useYn;
	private String regUser;
	
	/**
	 * ENTITY를 DTO로 변환
	 * @param sample - entity
	 * @return SampleDto
	 */
	public static SampleDto of(Sample sample) {
		return SampleDto.builder()
				.id(sample.getId())
				.name(sample.getName())
				.description(sample.getDescription())
				.useYn(sample.getUseYn())
				.regUser(sample.getRegUser())
				.build();
	}
	
	/**
	 * 조회요청 정보
	 * @author pjg
	 *
	 */
	@ToString
	@Getter
	@Setter
	public static class SearchRequest extends SearchDto {
		private String id;
	}
	
	/**
	 * 등록요청 정보
	 * @author pjg
	 *
	 */
	@ToString
	@Getter
	@Setter
	public static class RegistRequest {
		private String id;
		private String name;
		private String description;
		private String useYn;
		private String regUser;
	}
	
	/**
	 * 수정요청 정보
	 * @author pjg
	 *
	 */
	@ToString
	@Getter
	@Setter
	public static class UpdateRequest {
		private String id;
		private String name;
		private String description;
		private String useYn;
		private String regUser;
	}
	
	/**
	 * 삭제요청 정보
	 * @author pjg
	 *
	 */
	@ToString
	@Getter
	@Setter
	public static class DeleteRequest {
		private String id;
	}
}

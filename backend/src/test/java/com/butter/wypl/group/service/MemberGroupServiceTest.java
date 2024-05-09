package com.butter.wypl.group.service;

import static com.butter.wypl.global.common.Color.*;
import static com.butter.wypl.group.fixture.GroupFixture.*;
import static com.butter.wypl.member.fixture.MemberFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.butter.wypl.global.annotation.ServiceTest;
import com.butter.wypl.group.domain.MemberGroup;
import com.butter.wypl.group.repository.MemberGroupRepository;
import com.butter.wypl.schedule.data.response.MemberResponse;

@ServiceTest
class MemberGroupServiceTest {

	@InjectMocks
	private MemberGroupService memberGroupService;

	@Mock
	private MemberGroupRepository memberGroupRepository;

	@Test
	@DisplayName("그룹 아이디로 그룹에 포함된 멤버 조회")
	void getMembersByGroupId() {
		
		/* Given */
		List<MemberGroup> memberGroups = Arrays.asList(
			MemberGroup.of(HAN_JI_WON.toMember(), GROUP_STUDY.toGroup(HAN_JI_WON.toMember()), labelGreen),
			MemberGroup.of(KIM_JEONG_UK.toMember(), GROUP_STUDY.toGroup(HAN_JI_WON.toMember()), labelGreen),
			MemberGroup.of(LEE_JI_WON.toMember(), GROUP_STUDY.toGroup(HAN_JI_WON.toMember()), labelGreen)
		);
		List<String> memberNicknames = Arrays.asList(HAN_JI_WON.getNickname(), KIM_JEONG_UK.getNickname(),
			LEE_JI_WON.getNickname());
		given(memberGroupRepository.findMemberGroupsByGroupId(any(Integer.class)))
			.willReturn(memberGroups);
		int groupId = 1;

		/* When */
		List<MemberResponse> memberResponseList = memberGroupService.getMembersByGroupId(groupId);

		/* Then */
		memberResponseList.forEach(
			memberResponse -> {
				assertThat(memberNicknames.contains(memberResponse.nickname())).isTrue();
			}
		);
	}

}
package UMC.UMC_7th_mission.web.controller;

import UMC.UMC_7th_mission.Converter.MemberConverter;
import UMC.UMC_7th_mission.apiPayload.ApiResponse;
import UMC.UMC_7th_mission.domain.Member;
import UMC.UMC_7th_mission.service.MemberService.MemberCommandService;
import UMC.UMC_7th_mission.web.dto.Member.MemberRequestDTO;
import UMC.UMC_7th_mission.web.dto.Member.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        System.out.println("!!!");
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}

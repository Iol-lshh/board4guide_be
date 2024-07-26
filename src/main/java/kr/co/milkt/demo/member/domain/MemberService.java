package kr.co.milkt.demo.member.domain;

import kr.co.milkt.demo.member.domain.component.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;


}

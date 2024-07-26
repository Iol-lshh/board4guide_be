package kr.co.milkt.demo.member.infrastructure;

import kr.co.milkt.demo.common.library.client.MemberClient;
import kr.co.milkt.demo.member.domain.component.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImplement implements MemberRepository {
    private final MemberClient memberClient;

}

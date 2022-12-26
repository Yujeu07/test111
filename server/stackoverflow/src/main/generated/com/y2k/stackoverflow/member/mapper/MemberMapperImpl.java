package com.y2k.stackoverflow.member.mapper;

import com.y2k.stackoverflow.member.dto.MemberDto;
import com.y2k.stackoverflow.member.dto.UserProfile;
import com.y2k.stackoverflow.member.entity.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-26T15:08:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostToMember(MemberDto.Post post) {
        if ( post == null ) {
            return null;
        }

        Member member = new Member();

        member.setDisplayName( post.getDisplayName() );
        member.setEmail( post.getEmail() );
        member.setPassword( post.getPassword() );

        return member;
    }

    @Override
    public Member memberPatchToMember(MemberDto.Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( patch.getMemberId() );
        member.setDisplayName( patch.getDisplayName() );
        member.setUserProfile( patch.getUserProfile() );

        return member;
    }

    @Override
    public MemberDto.Response memberToResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String displayName = null;
        String profileImage = null;
        Member.MemberStatus memberStatus = null;

        if ( member.getMemberId() != null ) {
            memberId = member.getMemberId();
        }
        displayName = member.getDisplayName();
        profileImage = member.getProfileImage();
        memberStatus = member.getMemberStatus();

        MemberDto.Response response = new MemberDto.Response( memberId, displayName, profileImage, memberStatus );

        return response;
    }

    @Override
    public MemberDto.DetailsResponse memberToDetailsResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String displayName = null;
        String profileImage = null;
        Member.MemberStatus memberStatus = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;
        UserProfile userProfile = null;

        if ( member.getMemberId() != null ) {
            memberId = member.getMemberId();
        }
        displayName = member.getDisplayName();
        profileImage = member.getProfileImage();
        memberStatus = member.getMemberStatus();
        createdAt = member.getCreatedAt();
        modifiedAt = member.getModifiedAt();
        userProfile = member.getUserProfile();

        MemberDto.DetailsResponse detailsResponse = new MemberDto.DetailsResponse( memberId, displayName, profileImage, memberStatus, createdAt, modifiedAt, userProfile );

        return detailsResponse;
    }

    @Override
    public List<MemberDto.Response> membersToResponseDto(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<MemberDto.Response> list = new ArrayList<MemberDto.Response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToResponseDto( member ) );
        }

        return list;
    }
}

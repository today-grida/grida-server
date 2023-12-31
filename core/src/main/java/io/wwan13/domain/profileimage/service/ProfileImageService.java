package io.wwan13.domain.profileimage.service;

import io.wwan13.domain.image.entity.Image;
import io.wwan13.domain.image.exception.ImageNotFoundException;
import io.wwan13.domain.image.repository.ImageRepository;
import io.wwan13.domain.member.entity.Member;
import io.wwan13.domain.member.exception.MemberNotFountException;
import io.wwan13.domain.member.repository.MemberRepository;
import io.wwan13.domain.profileimage.entity.ProfileImage;
import io.wwan13.domain.profileimage.repository.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileImageService {

    private final ProfileImageRepository profileImageRepository;
    private final MemberRepository memberRepository;
    private final ImageRepository imageRepository;

    public Long save(String memberEmail, String imageUrl) {
        Member member = memberRepository.findByEmailEmail(memberEmail)
                .orElseThrow(() -> new MemberNotFountException());
        Image image = imageRepository.save(new Image(imageUrl));

        ProfileImage profileImage = ProfileImage.builder()
                .member(member)
                .image(image)
                .build();
        ProfileImage createdProfileImage = profileImageRepository.save(profileImage);

        return createdProfileImage.getId();
    }
}

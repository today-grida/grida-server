package io.wwan13.domain.member.exception;

import io.wwan13.constant.HttpStatusCode;
import io.wwan13.exeption.base.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {

    EMAIL_FORMAT_ERROR(HttpStatusCode.BAD_REQUEST, "이메일 형식이 잘못되었습니다."),
    PASSWORD_SIZE_ERROR(HttpStatusCode.BAD_REQUEST, "비밀번호는 최소 4자리 최대 12자리로 설정해 주세요."),
    NICKNAME_SIZE_ERROR(HttpStatusCode.BAD_REQUEST, "닉네임은 최소 2자 최대 12자리 설정해 주세요."),
    AGE_VALUE_ERROR(HttpStatusCode.BAD_REQUEST, "나이는 1 이하일 수 없슨디ㅏ."),
    MEMBER_NOT_FOUND(HttpStatusCode.BAD_REQUEST, "해당하는 유저를 찾을 수 없습니다.")
    ;

    private final int httpStatus;
    private final String message;
}
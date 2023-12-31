package io.wwan13.domain.diary.entity;

import io.wwan13.common.basetime.BaseTimeEntity;
import io.wwan13.domain.diary.entity.wrap.DiaryContent;
import io.wwan13.domain.diary.entity.wrap.DiaryDate;
import io.wwan13.domain.diary.entity.wrap.DiaryScope;
import io.wwan13.domain.diary.entity.wrap.RefreshChance;
import io.wwan13.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long id;

    @Embedded
    private DiaryContent content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member owner;

    @Enumerated(EnumType.STRING)
    private DiaryScope scope;

    @Embedded
    private DiaryDate date;

    @Embedded
    private RefreshChance refreshChance;

    @Builder
    public Diary(String content, Member owner, DiaryScope scope, LocalDate date) {
        this.content = new DiaryContent(content);
        this.owner = owner;
        this.scope = scope;
        this.date = new DiaryDate(date);
        this.refreshChance = new RefreshChance(owner.getAuthority());
    }

    public Integer refresh() {
        return refreshChance.refresh();
    }

    public String getContentValue() {
        return content.getContent();
    }
}

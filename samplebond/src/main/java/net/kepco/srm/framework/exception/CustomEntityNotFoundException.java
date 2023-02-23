package net.kepco.srm.framework.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.util.StringUtils;

import net.kepco.srm.framework.Audit;

public class CustomEntityNotFoundException extends EntityNotFoundException {
    private Object id;
    private Class<? extends Audit<Long>> clazz;
    private String targetMessage;


    public CustomEntityNotFoundException(Object id, Class<? extends Audit<?>> clazz, String targetMessage) {
        super(StringUtils.hasText(targetMessage) ? targetMessage : "해당 엔티티를 찾을 수 없습니다 [Id : " +  id +"], [Type : " + clazz.getSimpleName() + "]");
    }

}

package com.minimajack.v8.metadata.external.tabularsection;

import java.util.UUID;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.FillChecking;
import com.minimajack.v8.metadata.external.common.V8MetaFullName;
import com.minimajack.v8.metadata.external.common.V8Synonym;

@V8Class
public class TabularSectionDescription
{
    public Integer version;

    public UUID g1;

    public UUID g2;

    public UUID g3;

    public UUID g4;

    public V8MetaFullName name;

    /**
     * Проверка заполнения
     */
    public FillChecking fillChecking;

    /**
     * TODO: some object
     */
    public V8Synonym unk2;

    /**
     * Подсказка
     */
    public V8Synonym toolTip;
}

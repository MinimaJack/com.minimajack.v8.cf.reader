package com.minimajack.v8.metadata.external;

import java.util.UUID;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.enums.CreateOnInput;
import com.minimajack.v8.metadata.enums.FillChecking;
import com.minimajack.v8.metadata.enums.FoldersAndItemsUse;
import com.minimajack.v8.metadata.enums.UseQuickChoice;
import com.minimajack.v8.metadata.external.common.TypeValue;
import com.minimajack.v8.metadata.external.common.V8InnerVersion;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.common.V8TypeLinkDescription;
import com.minimajack.v8.metadata.external.unknown.V8Unknown2;

@V8Class
public class Description
{
    public Integer version;

    public V8MetaFullNameDescr fullname;

    /**
     * Режим пароля
     */
    public Boolean passwordMode;

    /**
     * Форматная строка
     */
    public V8Synonym format;

    /**
     * Подсказка
     */
    public V8Synonym tooltip;

    /**
     * Выделять отрицательные
     */
    public Boolean markNegatives;

    /**
     * Маска
     */
    public String mask;

    /**
     * Многострочный режим
     */
    public Boolean multiLine;

    /**
     * Минимальное значение
     */
    public TypeValue minValue;

    /**
     * Максимальное значение
     */
    public TypeValue maxValue;

    /**
     * Выбор групп и элементов
     */
    public FoldersAndItemsUse foldersAndItemsUse;

    public UUID g1;

    /**
     * Быстрый выбор 
     */
    public UseQuickChoice quickChoice;

    /**
     * Проверка заполнения 
     */
    public FillChecking fillChecking;

    public V8InnerVersion innerVersion;

    /**
     * Связь по типу
     */
    public V8TypeLinkDescription linkDescription;

    public V8Unknown2 unk10;

    /**
     *  Выделять отрицательное
     */
    public Boolean extendedEdit;

    /**
     * Формат редактирования
     */
    public V8Synonym formatEditing;

    public TypeValue unk12;

    public Integer unk13;

    /**
     * Создание при вводе
     */
    @Required(required = false)
    public CreateOnInput сreateOnInput;

    /**
     * Ведение истории выбора при вводе
     */
    @Required(required = false)
    public ChoiceHistoryOnInput choiceHistoryOnInput;

    public void afterUnmarshal()
    {
        // System.out.println( formatEditing.getForLanguage( "ru" ) );
    }
}

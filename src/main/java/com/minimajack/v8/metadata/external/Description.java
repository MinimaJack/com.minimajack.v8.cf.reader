package com.minimajack.v8.metadata.external;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.enums.CreateOnInput;
import com.minimajack.v8.metadata.enums.FillChecking;
import com.minimajack.v8.metadata.enums.FoldersAndItemsUse;
import com.minimajack.v8.metadata.enums.UseQuickChoice;
import com.minimajack.v8.metadata.external.common.ChoiceParameterLinks;
import com.minimajack.v8.metadata.external.common.ChoiceParameters;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.common.TypeLinks;
import com.minimajack.v8.metadata.external.type.TypeValue;

import java.util.UUID;

@V8Class
public class Description {

  @V8Version
  public Integer version;

  public V8MetaFullNameDescr fullname;

  /**
   * Режим пароля.
   */
  public Boolean passwordMode;

  /**
   * Форматная строка.
   */
  public V8Synonym format;

  /**
   * Подсказка.
   */
  public V8Synonym tooltip;

  /**
   * Выделять отрицательные.
   */
  public Boolean markNegatives;

  /**
   * Маска.
   */
  public String mask;

  /**
   * Многострочный режим.
   */
  public Boolean multiLine;

  /**
   * Минимальное значение.
   */
  public TypeValue minValue;

  /**
   * Максимальное значение.
   */
  public TypeValue maxValue;

  /**
   * Выбор групп и элементов.
   */
  public FoldersAndItemsUse foldersAndItemsUse;

  /**
   * Форма выбора.
   */
  public UUID choiceForm;

  /**
   * Быстрый выбор.
   */
  public UseQuickChoice quickChoice;

  /**
   * Проверка заполнения.
   */
  public FillChecking fillChecking;

  /**
   * Связи параметров выбора.
   */
  public ChoiceParameterLinks choiceParameterLinks;

  /**
   * Связь по типу.
   */
  public TypeLinks typeLinks;

  /**
   * Параметры выбора.
   */
  public ChoiceParameters choiceParameters;

  /**
   * Выделять отрицательное.
   */
  public Boolean extendedEdit;

  /**
   * Формат редактирования.
   */
  public V8Synonym formatEditing;

  public TypeValue unk12;

  public Integer unk13; // some flag

  /**
   * Создание при вводе.
   */
  @V8Since(version = 27)
  public CreateOnInput createOnInput;

  /**
   * Ведение истории выбора при вводе.
   */
  @V8Since(version = 27)
  public ChoiceHistoryOnInput choiceHistoryOnInput;

}

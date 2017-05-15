package com.minimajack.v8.metadata.external.tabularsection;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8MetaFullName;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.tabularsection.strange.StrangeObject;
import com.minimajack.v8.metadata.inner.enums.FillChecking;

import java.util.UUID;

@V8Class
public class TabularSectionDescription {

  public Integer version;

  public UUID g1;

  public UUID g2;

  public UUID g3;

  public UUID g4;

  public V8MetaFullName name;

  /**
   * Проверка заполнения.
   */
  public FillChecking fillChecking;

  /**
   * Странный объект - возможно конфигурация или версии классов.
   * TODO: some object need to discover
   */
  public StrangeObject unksyn;

  /**
   * Подсказка.
   */
  public V8Synonym toolTip;
}

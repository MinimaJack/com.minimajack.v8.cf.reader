package com.minimajack.v8.metadata.innerclass.transformer;

import com.minimajack.v8.metadata.innerclass.V8InnerClass;
import com.minimajack.v8.metadata.innerclass.attributes.AttributesList;
import com.minimajack.v8.metadata.innerclass.commands.CommandList;
import com.minimajack.v8.metadata.innerclass.configuration.accounting.AccountingConfiguraionMetaData;
import com.minimajack.v8.metadata.innerclass.configuration.accounting.AccountingRegisters;
import com.minimajack.v8.metadata.innerclass.configuration.accounting.ChartsOfAccounts;
import com.minimajack.v8.metadata.innerclass.configuration.businessprocesses.BusinessProcesses;
import com.minimajack.v8.metadata.innerclass.configuration.businessprocesses.BusinessProcessesConfiguraionMetaData;
import com.minimajack.v8.metadata.innerclass.configuration.businessprocesses.Tasks;
import com.minimajack.v8.metadata.innerclass.configuration.calculation.CalculationConfiguraionMetaData;
import com.minimajack.v8.metadata.innerclass.configuration.calculation.CalculationRegisters;
import com.minimajack.v8.metadata.innerclass.configuration.calculation.ChartsOfCalculation;
import com.minimajack.v8.metadata.innerclass.configuration.common.CommonAttributes;
import com.minimajack.v8.metadata.innerclass.configuration.common.CommonConfiguraionMetaData;
import com.minimajack.v8.metadata.innerclass.configuration.common.CommonModules;
import com.minimajack.v8.metadata.innerclass.configuration.common.CommonPictures;
import com.minimajack.v8.metadata.innerclass.configuration.common.CommonTemplates;
import com.minimajack.v8.metadata.innerclass.configuration.common.DefinedTypes;
import com.minimajack.v8.metadata.innerclass.configuration.common.EventSubscriptions;
import com.minimajack.v8.metadata.innerclass.configuration.common.ExchangePlans;
import com.minimajack.v8.metadata.innerclass.configuration.common.FilterCriteria;
import com.minimajack.v8.metadata.innerclass.configuration.common.FunctionalOptionParams;
import com.minimajack.v8.metadata.innerclass.configuration.common.FunctionalOptions;
import com.minimajack.v8.metadata.innerclass.configuration.common.HttpServices;
import com.minimajack.v8.metadata.innerclass.configuration.common.Interfaces;
import com.minimajack.v8.metadata.innerclass.configuration.common.Languages;
import com.minimajack.v8.metadata.innerclass.configuration.common.Roles;
import com.minimajack.v8.metadata.innerclass.configuration.common.ScheduledJobs;
import com.minimajack.v8.metadata.innerclass.configuration.common.SessionParams;
import com.minimajack.v8.metadata.innerclass.configuration.common.SettingsStorages;
import com.minimajack.v8.metadata.innerclass.configuration.common.StyleItems;
import com.minimajack.v8.metadata.innerclass.configuration.common.Styles;
import com.minimajack.v8.metadata.innerclass.configuration.common.Subsystems;
import com.minimajack.v8.metadata.innerclass.configuration.common.WebServices;
import com.minimajack.v8.metadata.innerclass.configuration.common.WsReferences;
import com.minimajack.v8.metadata.innerclass.configuration.common.XdtoPackages;
import com.minimajack.v8.metadata.innerclass.configuration.externaldatasources.ExternalDataSources;
import com.minimajack.v8.metadata.innerclass.configuration.externaldatasources.ExternalDataSourcesConfiguraionMetaData;
import com.minimajack.v8.metadata.innerclass.configuration.main.AccumulationRegisters;
import com.minimajack.v8.metadata.innerclass.configuration.main.Catalogs;
import com.minimajack.v8.metadata.innerclass.configuration.main.ChartsOfCharacteristicTypes;
import com.minimajack.v8.metadata.innerclass.configuration.main.CommandGroups;
import com.minimajack.v8.metadata.innerclass.configuration.main.CommonCommands;
import com.minimajack.v8.metadata.innerclass.configuration.main.CommonForms;
import com.minimajack.v8.metadata.innerclass.configuration.main.Constants;
import com.minimajack.v8.metadata.innerclass.configuration.main.DataProcessors;
import com.minimajack.v8.metadata.innerclass.configuration.main.DocumentJournals;
import com.minimajack.v8.metadata.innerclass.configuration.main.DocumentNumerators;
import com.minimajack.v8.metadata.innerclass.configuration.main.Documents;
import com.minimajack.v8.metadata.innerclass.configuration.main.Enums;
import com.minimajack.v8.metadata.innerclass.configuration.main.InformationRegisters;
import com.minimajack.v8.metadata.innerclass.configuration.main.MainConfiguraionMetaData;
import com.minimajack.v8.metadata.innerclass.configuration.main.Reports;
import com.minimajack.v8.metadata.innerclass.configuration.main.Sequences;
import com.minimajack.v8.metadata.innerclass.externaldataprocessor.ExternalDataProcessorMetaData;
import com.minimajack.v8.metadata.innerclass.forms.FormList;
import com.minimajack.v8.metadata.innerclass.tabular.TabularList;
import com.minimajack.v8.metadata.innerclass.template.TemplateList;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

public class InnerClassTransformer extends AbstractTransformer<V8InnerClass> {

  public static final UUID FORMS_SECTION = UUID
      .fromString("d5b0e5ed-256d-401c-9c36-f630cafd8a62");

  public static final UUID FORMS = UUID.fromString("fdf816d2-1ead-11d5-b975-0050bae0a95d");

  public static final UUID TEMPLATE_SECTION = UUID
      .fromString("3daea016-69b7-4ed4-9453-127911372fe6");

  public static final UUID ATTRIBUTES_SECTION = UUID
      .fromString("ec6bb5e5-b7a8-4d75-bec9-658107a699cf");

  public static final UUID ATTRIBUTES = UUID.fromString("cf4abea7-37b2-11d4-940f-008048da11f9");

  public static final UUID TABULAR_SECTION = UUID
      .fromString("2bcef0d1-0981-11d6-b9b8-0050bae0a95d");

  public static final UUID TABULARS = UUID.fromString("932159f9-95b2-4e76-a8dd-8849fe5c5ded");

  public static final UUID ROLE_SECTION = UUID
      .fromString("09736b02-9cac-4e3f-b4f7-d3e9576ab948");

  public static final UUID COMMON_TEMPLATES_SECTION = UUID
      .fromString("0c89c792-16c3-11d5-b96b-0050bae0a95d");

  public static final UUID COMMON_MODULES_SECTION = UUID
      .fromString("0fe48980-252d-11d6-a3c7-0050bae0a776");

  public static final UUID SCHEDULED_JOBS_SECTION = UUID
      .fromString("11bdaf85-d5ad-4d91-bb24-aa0eee139052");

  public static final UUID COMMON_ATTRIBUTES_SECTION = UUID
      .fromString("15794563-ccec-41f6-a83c-ec5f7b9a5bc1");

  public static final UUID SESSION_PARAMS_SECTION = UUID
      .fromString("24c43748-c938-45d0-8d14-01424a72b11e");

  public static final UUID FUNC_OPTIONS_PARAMS_SECTION = UUID
      .fromString("30d554db-541e-4f62-8970-a1c6dcfeb2bc");

  public static final UUID HTTP_SERVICES_SECTION = UUID
      .fromString("0fffc09c-8f4c-47cc-b41c-8d5c5a221d79");

  public static final UUID SUBSYSTEMS_SECTION = UUID
      .fromString("37f2fa9a-b276-11d4-9435-004095e12fc7");

  public static final UUID INTERFACES_SECTION = UUID
      .fromString("39bddf6a-0c3c-452b-921c-d99cfa1c2f1b");

  public static final UUID STYLES_SECTION = UUID
      .fromString("3e5404af-6ef8-4c73-ad11-91bd2dfac4c8");

  public static final UUID FILTER_CRITERIA_SECTION = UUID
      .fromString("3e7bfcc0-067d-11d6-a3c7-0050bae0a776");

  public static final UUID SETTINGS_STORAGES_SECTION = UUID
      .fromString("46b4cd97-fd13-4eaa-aba2-3bddd7699218");

  public static final UUID EVENT_SUBSCRIPTIONS_SECTION = UUID
      .fromString("4e828da6-0f44-4b5b-b1c0-a2b3cfe7bdcc");

  public static final UUID STYLE_ITEMS_SECTION = UUID
      .fromString("58848766-36ea-4076-8800-e91eb49590d7");

  public static final UUID COMMON_PICTURES_SECTION = UUID
      .fromString("7dcd43d9-aca5-4926-b549-1842e6a4e8cf");

  public static final UUID EXCHANGE_PLANS_SECTION = UUID
      .fromString("857c4a91-e5f4-4fac-86ec-787626f1c108");

  public static final UUID WEB_SERVICES_SECTION = UUID
      .fromString("8657032e-7740-4e1d-a3ba-5dd6e8afb78f");

  public static final UUID LANGUAGES_SECTION = UUID
      .fromString("9cd510ce-abfc-11d4-9434-004095e12fc7");

  public static final UUID FUNCTIONAL_OPTIONS_SECTION = UUID
      .fromString("af547940-3268-434f-a3e7-e47d6d2638c3");

  public static final UUID DEFINED_TYPES_SECTION = UUID
      .fromString("c045099e-13b9-4fb6-9d50-fca00202971e");

  public static final UUID XDTO_PACKAGES_SECTION = UUID
      .fromString("cc9df798-7c94-4616-97d2-7aa0b7bc515e");

  public static final UUID WS_REFERENCES_SECTION = UUID
      .fromString("d26096fb-7a5d-4df9-af63-47d04771fa9b");

  public static final UUID CONSTANTS_SECTION = UUID
      .fromString("0195e80c-b157-11d4-9435-004095e12fc7");

  public static final UUID DOCUMENTS_SECTION = UUID
      .fromString("061d872a-5787-460e-95ac-ed74ea3a3e84");

  public static final UUID COMMON_FORMS_SECTION = UUID
      .fromString("07ee8426-87f1-11d5-b99c-0050bae0a95d");

  public static final UUID INFORMATION_REGISTERS_SECTION = UUID
      .fromString("13134201-f60b-11d5-a3c7-0050bae0a776");

  public static final UUID COMMAND_GROUPS_SECTION = UUID
      .fromString("1c57eabe-7349-44b3-b1de-ebfeab67b47d");

  public static final UUID COMMON_COMMANDS_SECTION = UUID
      .fromString("2f1a5187-fb0e-4b05-9489-dc5dd6412348");

  public static final UUID DOCUMENT_NUMERATORS_SECTION = UUID
      .fromString("36a8e346-9aaa-4af9-bdbd-83be3c177977");

  public static final UUID DOCUMENT_JOURNALS_SECTION = UUID
      .fromString("4612bd75-71b7-4a5c-8cc5-2b0b65f9fa0d");

  public static final UUID REPORTS_SECTION = UUID
      .fromString("631b75a0-29e2-11d6-a3c7-0050bae0a776");

  public static final UUID CHARTS_OF_CHARACTERISTIC_TYPES_SECTION = UUID
      .fromString("82a1b659-b220-4d94-a9bd-14d757b95a48");

  public static final UUID ACCUMULATION_REGISTERS_SECTION = UUID
      .fromString("b64d9a40-1642-11d6-a3c7-0050bae0a776");

  public static final UUID SEQUENCES_SECTION = UUID
      .fromString("bc587f20-35d9-11d6-a3c7-0050bae0a776");

  public static final UUID DATA_PROCESSORS_SECTION = UUID
      .fromString("bf845118-327b-4682-b5c6-285d2a0eb296");

  public static final UUID CATALOGS_SECTION = UUID
      .fromString("cf4abea6-37b2-11d4-940f-008048da11f9");

  public static final UUID ENUMS_SECTION = UUID
      .fromString("f6a80749-5ad7-400b-8519-39dc5dff2542");

  public static final UUID CHARTS_OF_ACCOUNTS_SECTION = UUID
      .fromString("238e7e88-3c5f-48b2-8a3b-81ebbecb20ed");

  public static final UUID ACCOUNTING_REGISTERS_SECTION = UUID
      .fromString("2deed9b8-0056-4ffe-a473-c20a6c32a0bc");

  public static final UUID CHARTS_OF_CALCULATION_TYPES_SECTION = UUID
      .fromString("30b100d6-b29f-47ac-aec7-cb8ca8a54767");

  public static final UUID CALCULATION_REGISTERS_SECTION = UUID
      .fromString("f2de87a8-64e5-45eb-a22d-b3aedab050e7");

  public static final UUID TASKS_SECTION = UUID
      .fromString("3e63355c-1378-4953-be9b-1deb5fb6bec5");

  public static final UUID BUSINESS_PROCESSES_SECTION = UUID
      .fromString("fcd3404e-1523-48ce-9bc0-ecdb822684a1");

  public static final UUID EXTERNAL_DATA_SOURCES_SECTION = UUID
      .fromString("5274d9fc-9c3a-4a71-8f5e-a0db8ab23de5");

  public static final UUID EXTERNAL_DATA_PROCESSOR = UUID
      .fromString("c3831ec8-d8d5-4f93-8a22-f9bfae07327f");

  public static final UUID COMMON_CONFIGURATION_BLOCK = UUID
      .fromString("9cd510cd-abfc-11d4-9434-004095e12fc7");

  public static final UUID MAIN_CONFIGURATION_BLOCK = UUID
      .fromString("9fcd25a0-4822-11d4-9414-008048da11f9");

  public static final UUID ACCOUNTING_CONFIGURATION_BLOCK = UUID
      .fromString("e3687481-0a87-462c-a166-9f34594f9bba");

  public static final UUID CALCULATION_CONFIGURATION_BLOCK = UUID
      .fromString("9de14907-ec23-4a07-96f0-85521cb6b53b");

  public static final UUID BUSINESS_PROCESSES_CONFIGURATION_BLOCK = UUID
      .fromString("51f2d5d8-ea4d-4064-8892-82951750031e");

  public static final UUID EXTERNAL_DATA_SOURCES_CONFIGURATION_BLOCK = UUID
      .fromString("e68182ea-4237-4383-967f-90c1e3370bc7");

  public static final UUID COMMAND_LIST = UUID
      .fromString("4fe87c89-9ad4-43f6-9fdb-9dc83b3879c6");

  public static final UUID TABULAR_DOCUMENTS = UUID
      .fromString("21c53e09-8950-4b5e-a6a0-1054f1bbc274");

  public static final UUID ATTRIBUTES_DOCUMENTS = UUID
      .fromString("45e46cbc-3e24-4165-8b7b-cc98a6f80211");

  public static final UUID COMMAND_LIST_DOCUMENTS = UUID
      .fromString("b544fc6a-2ba3-4885-8fb2-cb289fb6d65e");

  public static final UUID TEMPLATES_SECTION_DOCUMENTS = UUID
      .fromString("fb880e93-47d7-4127-9357-a20e69c17545");

  @Override
  public V8InnerClass read(final ParameterizedType type, final ByteBuffer buffer) {
    buffer.mark();
    V8InnerClass innerClass = null;
    ClassTransformer.readBracket(buffer);
    final UUID guid = V8Reader.read(UUID.class, buffer);
    buffer.reset();
    if (guid.equals(FORMS_SECTION)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(TEMPLATE_SECTION)) {
      innerClass = V8Reader.read(TemplateList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_SECTION)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(TABULAR_SECTION)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(ROLE_SECTION)) {
      innerClass = V8Reader.read(Roles.class, buffer);
    } else if (guid.equals(COMMON_TEMPLATES_SECTION)) {
      innerClass = V8Reader.read(CommonTemplates.class, buffer);
    } else if (guid.equals(COMMON_MODULES_SECTION)) {
      innerClass = V8Reader.read(CommonModules.class, buffer);
    } else if (guid.equals(SCHEDULED_JOBS_SECTION)) {
      innerClass = V8Reader.read(ScheduledJobs.class, buffer);
    } else if (guid.equals(COMMON_ATTRIBUTES_SECTION)) {
      innerClass = V8Reader.read(CommonAttributes.class, buffer);
    } else if (guid.equals(SESSION_PARAMS_SECTION)) {
      innerClass = V8Reader.read(SessionParams.class, buffer);
    } else if (guid.equals(FUNC_OPTIONS_PARAMS_SECTION)) {
      innerClass = V8Reader.read(FunctionalOptionParams.class, buffer);
    } else if (guid.equals(HTTP_SERVICES_SECTION)) {
      innerClass = V8Reader.read(HttpServices.class, buffer);
    } else if (guid.equals(SUBSYSTEMS_SECTION)) {
      innerClass = V8Reader.read(Subsystems.class, buffer);
    } else if (guid.equals(INTERFACES_SECTION)) {
      innerClass = V8Reader.read(Interfaces.class, buffer);
    } else if (guid.equals(STYLES_SECTION)) {
      innerClass = V8Reader.read(Styles.class, buffer);
    } else if (guid.equals(FILTER_CRITERIA_SECTION)) {
      innerClass = V8Reader.read(FilterCriteria.class, buffer);
    } else if (guid.equals(SETTINGS_STORAGES_SECTION)) {
      innerClass = V8Reader.read(SettingsStorages.class, buffer);
    } else if (guid.equals(EVENT_SUBSCRIPTIONS_SECTION)) {
      innerClass = V8Reader.read(EventSubscriptions.class, buffer);
    } else if (guid.equals(STYLE_ITEMS_SECTION)) {
      innerClass = V8Reader.read(StyleItems.class, buffer);
    } else if (guid.equals(COMMON_PICTURES_SECTION)) {
      innerClass = V8Reader.read(CommonPictures.class, buffer);
    } else if (guid.equals(EXCHANGE_PLANS_SECTION)) {
      innerClass = V8Reader.read(ExchangePlans.class, buffer);
    } else if (guid.equals(WEB_SERVICES_SECTION)) {
      innerClass = V8Reader.read(WebServices.class, buffer);
    } else if (guid.equals(LANGUAGES_SECTION)) {
      innerClass = V8Reader.read(Languages.class, buffer);
    } else if (guid.equals(FUNCTIONAL_OPTIONS_SECTION)) {
      innerClass = V8Reader.read(FunctionalOptions.class, buffer);
    } else if (guid.equals(DEFINED_TYPES_SECTION)) {
      innerClass = V8Reader.read(DefinedTypes.class, buffer);
    } else if (guid.equals(XDTO_PACKAGES_SECTION)) {
      innerClass = V8Reader.read(XdtoPackages.class, buffer);
    } else if (guid.equals(WS_REFERENCES_SECTION)) {
      innerClass = V8Reader.read(WsReferences.class, buffer);
    } else if (guid.equals(CONSTANTS_SECTION)) {
      innerClass = V8Reader.read(Constants.class, buffer);
    } else if (guid.equals(DOCUMENTS_SECTION)) {
      innerClass = V8Reader.read(Documents.class, buffer);
    } else if (guid.equals(COMMON_FORMS_SECTION)) {
      innerClass = V8Reader.read(CommonForms.class, buffer);
    } else if (guid.equals(INFORMATION_REGISTERS_SECTION)) {
      innerClass = V8Reader.read(InformationRegisters.class, buffer);
    } else if (guid.equals(COMMAND_GROUPS_SECTION)) {
      innerClass = V8Reader.read(CommandGroups.class, buffer);
    } else if (guid.equals(COMMON_COMMANDS_SECTION)) {
      innerClass = V8Reader.read(CommonCommands.class, buffer);
    } else if (guid.equals(DOCUMENT_NUMERATORS_SECTION)) {
      innerClass = V8Reader.read(DocumentNumerators.class, buffer);
    } else if (guid.equals(DOCUMENT_JOURNALS_SECTION)) {
      innerClass = V8Reader.read(DocumentJournals.class, buffer);
    } else if (guid.equals(REPORTS_SECTION)) {
      innerClass = V8Reader.read(Reports.class, buffer);
    } else if (guid.equals(CHARTS_OF_CHARACTERISTIC_TYPES_SECTION)) {
      innerClass = V8Reader.read(ChartsOfCharacteristicTypes.class, buffer);
    } else if (guid.equals(ACCUMULATION_REGISTERS_SECTION)) {
      innerClass = V8Reader.read(AccumulationRegisters.class, buffer);
    } else if (guid.equals(SEQUENCES_SECTION)) {
      innerClass = V8Reader.read(Sequences.class, buffer);
    } else if (guid.equals(DATA_PROCESSORS_SECTION)) {
      innerClass = V8Reader.read(DataProcessors.class, buffer);
    } else if (guid.equals(CATALOGS_SECTION)) {
      innerClass = V8Reader.read(Catalogs.class, buffer);
    } else if (guid.equals(ENUMS_SECTION)) {
      innerClass = V8Reader.read(Enums.class, buffer);
    } else if (guid.equals(CHARTS_OF_ACCOUNTS_SECTION)) {
      innerClass = V8Reader.read(ChartsOfAccounts.class, buffer);
    } else if (guid.equals(ACCOUNTING_REGISTERS_SECTION)) {
      innerClass = V8Reader.read(AccountingRegisters.class, buffer);
    } else if (guid.equals(CHARTS_OF_CALCULATION_TYPES_SECTION)) {
      innerClass = V8Reader.read(ChartsOfCalculation.class, buffer);
    } else if (guid.equals(CALCULATION_REGISTERS_SECTION)) {
      innerClass = V8Reader.read(CalculationRegisters.class, buffer);
    } else if (guid.equals(TASKS_SECTION)) {
      innerClass = V8Reader.read(Tasks.class, buffer);
    } else if (guid.equals(BUSINESS_PROCESSES_SECTION)) {
      innerClass = V8Reader.read(BusinessProcesses.class, buffer);
    } else if (guid.equals(EXTERNAL_DATA_SOURCES_SECTION)) {
      innerClass = V8Reader.read(ExternalDataSources.class, buffer);
    } else if (guid.equals(EXTERNAL_DATA_PROCESSOR)) {
      innerClass = V8Reader.read(ExternalDataProcessorMetaData.class, buffer); // another
    } else if (guid.equals(COMMON_CONFIGURATION_BLOCK)) {
      innerClass = V8Reader.read(CommonConfiguraionMetaData.class, buffer);
    } else if (guid.equals(MAIN_CONFIGURATION_BLOCK)) {
      innerClass = V8Reader.read(MainConfiguraionMetaData.class, buffer);
    } else if (guid.equals(ACCOUNTING_CONFIGURATION_BLOCK)) {
      innerClass = V8Reader.read(AccountingConfiguraionMetaData.class, buffer);
    } else if (guid.equals(CALCULATION_CONFIGURATION_BLOCK)) {
      innerClass = V8Reader.read(CalculationConfiguraionMetaData.class, buffer);
    } else if (guid.equals(BUSINESS_PROCESSES_CONFIGURATION_BLOCK)) {
      innerClass = V8Reader.read(BusinessProcessesConfiguraionMetaData.class, buffer);
    } else if (guid.equals(EXTERNAL_DATA_SOURCES_CONFIGURATION_BLOCK)) {
      innerClass = V8Reader.read(ExternalDataSourcesConfiguraionMetaData.class, buffer);
    } else if (guid.equals(COMMAND_LIST)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(TABULARS)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(ATTRIBUTES)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(FORMS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(TABULAR_DOCUMENTS)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_DOCUMENTS)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(COMMAND_LIST_DOCUMENTS)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(TEMPLATES_SECTION_DOCUMENTS)) {
      innerClass = V8Reader.read(TemplateList.class, buffer);
    } else {
      throw new RuntimeException("Unknown section: " + guid);
    }

    return innerClass;
  }

}

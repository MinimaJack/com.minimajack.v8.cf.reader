package com.minimajack.v8.metadata.inner.classes.transformer;

import com.minimajack.v8.metadata.inner.classes.V8InnerClass;
import com.minimajack.v8.metadata.inner.classes.attributes.AttributesAddressList;
import com.minimajack.v8.metadata.inner.classes.attributes.AttributesDocumentList;
import com.minimajack.v8.metadata.inner.classes.attributes.AttributesList;
import com.minimajack.v8.metadata.inner.classes.attributes.AttributesRegistersList;
import com.minimajack.v8.metadata.inner.classes.attributes.DimensionList;
import com.minimajack.v8.metadata.inner.classes.attributes.ResourceList;
import com.minimajack.v8.metadata.inner.classes.attributes.accounting.AccountingResourceList;
import com.minimajack.v8.metadata.inner.classes.attributes.calculation.CalculationAttributesList;
import com.minimajack.v8.metadata.inner.classes.attributes.calculation.CalculationDimensionList;
import com.minimajack.v8.metadata.inner.classes.attributes.calculation.CalculationResourceList;
import com.minimajack.v8.metadata.inner.classes.attributes.charts.accounting.extdimention.ExtDimensionAccountingFlags;
import com.minimajack.v8.metadata.inner.classes.attributes.charts.accounting.flag.AccountingFlags;
import com.minimajack.v8.metadata.inner.classes.attributes.charts.characteristics.ChartsOfCharacteristicTypesAttributesList;
import com.minimajack.v8.metadata.inner.classes.attributes.information.InformationDimensionList;
import com.minimajack.v8.metadata.inner.classes.attributes.information.InformationResourceList;
import com.minimajack.v8.metadata.inner.classes.commands.CommandList;
import com.minimajack.v8.metadata.inner.classes.commands.CommandListMetaDataObject;
import com.minimajack.v8.metadata.inner.classes.configuration.accounting.AccountingConfiguraionMetaData;
import com.minimajack.v8.metadata.inner.classes.configuration.accounting.AccountingRegisters;
import com.minimajack.v8.metadata.inner.classes.configuration.accounting.ChartsOfAccounts;
import com.minimajack.v8.metadata.inner.classes.configuration.businessprocesses.BusinessProcesses;
import com.minimajack.v8.metadata.inner.classes.configuration.businessprocesses.BusinessProcessesConfiguraionMetaData;
import com.minimajack.v8.metadata.inner.classes.configuration.businessprocesses.Tasks;
import com.minimajack.v8.metadata.inner.classes.configuration.calculation.CalculationConfiguraionMetaData;
import com.minimajack.v8.metadata.inner.classes.configuration.calculation.CalculationRegisters;
import com.minimajack.v8.metadata.inner.classes.configuration.calculation.ChartsOfCalculation;
import com.minimajack.v8.metadata.inner.classes.configuration.common.CommonAttributes;
import com.minimajack.v8.metadata.inner.classes.configuration.common.CommonConfiguraionMetaData;
import com.minimajack.v8.metadata.inner.classes.configuration.common.CommonModules;
import com.minimajack.v8.metadata.inner.classes.configuration.common.CommonPictures;
import com.minimajack.v8.metadata.inner.classes.configuration.common.CommonTemplates;
import com.minimajack.v8.metadata.inner.classes.configuration.common.DefinedTypes;
import com.minimajack.v8.metadata.inner.classes.configuration.common.EventSubscriptions;
import com.minimajack.v8.metadata.inner.classes.configuration.common.ExchangePlans;
import com.minimajack.v8.metadata.inner.classes.configuration.common.FilterCriteria;
import com.minimajack.v8.metadata.inner.classes.configuration.common.FunctionalOptionParams;
import com.minimajack.v8.metadata.inner.classes.configuration.common.FunctionalOptions;
import com.minimajack.v8.metadata.inner.classes.configuration.common.HttpServices;
import com.minimajack.v8.metadata.inner.classes.configuration.common.Interfaces;
import com.minimajack.v8.metadata.inner.classes.configuration.common.Languages;
import com.minimajack.v8.metadata.inner.classes.configuration.common.Roles;
import com.minimajack.v8.metadata.inner.classes.configuration.common.ScheduledJobs;
import com.minimajack.v8.metadata.inner.classes.configuration.common.SessionParams;
import com.minimajack.v8.metadata.inner.classes.configuration.common.SettingsStorages;
import com.minimajack.v8.metadata.inner.classes.configuration.common.StyleItems;
import com.minimajack.v8.metadata.inner.classes.configuration.common.Styles;
import com.minimajack.v8.metadata.inner.classes.configuration.common.Subsystems;
import com.minimajack.v8.metadata.inner.classes.configuration.common.WebServices;
import com.minimajack.v8.metadata.inner.classes.configuration.common.WsReferences;
import com.minimajack.v8.metadata.inner.classes.configuration.common.XdtoPackages;
import com.minimajack.v8.metadata.inner.classes.configuration.externaldatasources.ExternalDataSources;
import com.minimajack.v8.metadata.inner.classes.configuration.externaldatasources.ExternalDataSourcesConfiguraionMetaData;
import com.minimajack.v8.metadata.inner.classes.configuration.main.AccumulationRegisters;
import com.minimajack.v8.metadata.inner.classes.configuration.main.Catalogs;
import com.minimajack.v8.metadata.inner.classes.configuration.main.ChartsOfCharacteristicTypes;
import com.minimajack.v8.metadata.inner.classes.configuration.main.CommandGroups;
import com.minimajack.v8.metadata.inner.classes.configuration.main.CommonCommands;
import com.minimajack.v8.metadata.inner.classes.configuration.main.CommonForms;
import com.minimajack.v8.metadata.inner.classes.configuration.main.Constants;
import com.minimajack.v8.metadata.inner.classes.configuration.main.DataProcessors;
import com.minimajack.v8.metadata.inner.classes.configuration.main.DocumentJournals;
import com.minimajack.v8.metadata.inner.classes.configuration.main.DocumentNumerators;
import com.minimajack.v8.metadata.inner.classes.configuration.main.Documents;
import com.minimajack.v8.metadata.inner.classes.configuration.main.Enums;
import com.minimajack.v8.metadata.inner.classes.configuration.main.InformationRegisters;
import com.minimajack.v8.metadata.inner.classes.configuration.main.MainConfiguraionMetaData;
import com.minimajack.v8.metadata.inner.classes.configuration.main.Reports;
import com.minimajack.v8.metadata.inner.classes.configuration.main.Sequences;
import com.minimajack.v8.metadata.inner.classes.enums.EnumList;
import com.minimajack.v8.metadata.inner.classes.externaldataprocessor.ExternalDataProcessorMetaData;
import com.minimajack.v8.metadata.inner.classes.forms.FormList;
import com.minimajack.v8.metadata.inner.classes.sequences.SequencesDataList;
import com.minimajack.v8.metadata.inner.classes.tabular.TabularList;
import com.minimajack.v8.metadata.inner.classes.template.TemplateList;
import com.minimajack.v8.metadata.inner.classes.webservices.OperationParams;
import com.minimajack.v8.metadata.inner.classes.webservices.WebServiceList;
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

  public static final UUID UNK_REGISTERS = UUID
      .fromString("99f328af-a77f-4572-a2d8-80ed20c81890");

  public static final UUID RESOURCE_REGISTERS = UUID
      .fromString("b64d9a41-1642-11d6-a3c7-0050bae0a776");

  public static final UUID DIMENSION_REGISTERS = UUID
      .fromString("b64d9a42-1642-11d6-a3c7-0050bae0a776");

  public static final UUID ATTRIBUTES_REGISTERS = UUID
      .fromString("b64d9a43-1642-11d6-a3c7-0050bae0a776");

  public static final UUID FORMS_REGISTERS = UUID
      .fromString("b64d9a44-1642-11d6-a3c7-0050bae0a776");

  public static final UUID RESOURCE_INFORMATION_REGISTERS = UUID
      .fromString("13134202-f60b-11d5-a3c7-0050bae0a776");

  public static final UUID DIMENSION_INFORMATION_REGISTERS = UUID
      .fromString("13134203-f60b-11d5-a3c7-0050bae0a776");

  public static final UUID FORMS_INFORMATION_REGISTERS = UUID
      .fromString("13134204-f60b-11d5-a3c7-0050bae0a776");

  public static final UUID ATTRIBUTES_INFORMATION_REGISTERS = UUID
      .fromString("a2207540-1400-11d6-a3c7-0050bae0a776");

  public static final UUID COMMANDS_INFORMATION_REGISTERS = UUID
      .fromString("b44ba719-945c-445c-8aab-1088fa4df16e");

  public static final UUID ATTRIBUTES_REPORTS = UUID
      .fromString("7e7123e0-29e2-11d6-a3c7-0050bae0a776");

  public static final UUID FORM_REPORTS = UUID
      .fromString("a3b368c0-29e2-11d6-a3c7-0050bae0a776");

  public static final UUID TABULARS_REPORTS = UUID
      .fromString("b077d780-29e2-11d6-a3c7-0050bae0a776");

  public static final UUID COMMANDS_REPORTS = UUID
      .fromString("e7ff38c0-ec3c-47a0-ae90-20c73ca72246");

  public static final UUID COMMANDS_DATA_PROCESSORS = UUID
      .fromString("45556acb-826a-4f73-898a-6025fc9536e1");

  public static final UUID UNK1_ENUM = UUID.fromString("33f2e54b-37ce-4a7a-a569-b648d7aa4634");

  public static final UUID UNK2_ENUM = UUID.fromString("6d8d73a7-ba29-401d-9032-3872ec2d6433");

  public static final UUID VALUES_ENUM = UUID.fromString("bee0a08c-07eb-40c0-8544-5c364c171465");

  public static final UUID ATTRIBUTES_EXCHANGE_PLANS = UUID
      .fromString("1a1b4fea-e093-470d-94ff-1d2f16cda2ab");

  public static final UUID TABULARS_EXCHANGE_PLANS = UUID
      .fromString("52293f4b-f98c-43ea-a80f-41047ae7ab58");

  public static final UUID FORMS_EXCHANGE_PLANS = UUID
      .fromString("87c509ab-3d38-4d67-b379-aca796298578");

  public static final UUID COMMANDS_EXCHANGE_PLANS = UUID
      .fromString("d5207c64-11d5-4d46-bba2-55b7b07ff4eb");

  public static final UUID FORMS_FILTER_CRITERIA = UUID
      .fromString("00867c40-06b1-11d6-a3c7-0050bae0a776");

  public static final UUID COMMANDS_FILTER_CRITERIA = UUID
      .fromString("23fa3b84-220a-40e9-8331-e588bed87f7d");

  public static final UUID DATA_SEQUENCES = UUID
      .fromString("437488c0-35e2-11d6-a3c7-0050bae0a776");

  public static final UUID FORMS_SETTING_STORAGES = UUID
      .fromString("b8533c0c-2342-4db3-91a2-c2b08cbf6b23");

  public static final UUID FORMS_TASKS = UUID.fromString("3f58cbfb-4172-4e54-be49-561a579bb38b");

  public static final UUID ATTRIBUTES_TASKS = UUID
      .fromString("8ddfb495-c5fc-46b9-bdc5-bcf58341bff0");

  public static final UUID ATTRIBUTES_ADDRESS_TASKS = UUID
      .fromString("e97c0570-251c-4566-b0f1-10686820f143");

  public static final UUID TABULARS_TASKS = UUID
      .fromString("ee865d4b-a458-48a0-b38f-5a26898feeb0");

  public static final UUID COMMANDS_TASKS = UUID
      .fromString("f27c2152-a2c9-4c30-adb1-130f5eb2590f");

  public static final UUID OPERATION_WEB_SERVICE = UUID
      .fromString("36186084-c23a-43bd-876c-a3a8ba1a9622");

  public static final UUID OPERATION_PARAMS_WEB_SERVICE = UUID
      .fromString("b78a00b2-2260-4ef5-a70c-17889cfee695");

  public static final UUID ATTRIBUTES_ACCOUNTING = UUID
      .fromString("35b63b9d-0adf-4625-a047-10ae874c19a3");

  public static final UUID RESOURCE_ACCOUNTING = UUID
      .fromString("63405499-7491-4ce3-ac72-43433cbe4112");

  public static final UUID COMMANDS_ACCOUNTING = UUID
      .fromString("7162da60-f7fe-4d78-ad5d-e31700f9af18");

  public static final UUID DIMENSION_ACCOUNTING_REGISTERS = UUID
      .fromString("9d28ee33-9c7e-4a1b-8f13-50aa9b36607b");

  public static final UUID FORMS_ACCOUNTING_REGISTERS = UUID
      .fromString("d3b5d6eb-4ea2-4610-a3e2-624d4e815934");

  public static final UUID DIMENSION_CALCULATION_REGISTERS = UUID
      .fromString("1b304502-2216-440b-960f-60decd04bb5d");

  public static final UUID UNK1_CALCULATION_REGISTERS = UUID
      .fromString("274bf899-db0e-4df6-8ab5-67bf6371ec0b");

  public static final UUID RESOURCE_CALCULATION_REGISTERS = UUID
      .fromString("702b33ad-843e-41aa-8064-112cd38cc92c");

  public static final UUID UNK2_CALCULATION_REGISTERS = UUID
      .fromString("a2cb086c-db98-43e4-a1a9-0760ab048f8d");

  public static final UUID UNK3_CALCULATION_REGISTERS = UUID
      .fromString("acdf0f11-2d59-4e37-9945-c6721871a8fe");

  public static final UUID ATTRIBUTES_CALCULATION_REGISTERS = UUID
      .fromString("b12fc850-8210-43c8-ae05-89567e698fbb");

  public static final UUID COMMANDS_CHART_ACCOUNT = UUID
      .fromString("0df30176-6865-4787-9fc8-609eb144174f");

  public static final UUID TABULAR_CHART_ACCOUNT = UUID
      .fromString("4c7fec95-d1bd-4508-8a01-f1db090d9af8");

  public static final UUID FORMS_CHART_ACCOUNT = UUID
      .fromString("5372e285-03db-4f8c-8565-fe56f1aea40e");

  public static final UUID ATTRIBUTES_CHART_ACCOUNT = UUID
      .fromString("6e65cbf5-daa8-4d8d-bef8-59723f4e5777");

  public static final UUID FLAGS_CHART_ACCOUNT = UUID // признаки учета
      .fromString("78bd1243-c4df-46c3-8138-e147465cb9a4");

  public static final UUID EXT_DIMENTION_FLAGS_CHART_ACCOUNT = UUID // признаки учета
      .fromString("c70ca527-5042-4cad-a315-dcb4007e32a3");

  public static final UUID TABULAR_CHART_CALCULATION = UUID
      .fromString("054aa8cf-faa6-4634-aef4-1087ca0d88fc");

  public static final UUID ATTRIBUTES_CHART_CALCULATION = UUID
      .fromString("0dc22ad2-476a-4794-afae-cfa7ed251752");

  public static final UUID COMMANDS_CHART_CALCULATION = UUID
      .fromString("2e90c75b-2f0c-4899-a7d4-5426eaefc96e");

  public static final UUID FORMS_CHART_CALCULATION = UUID
      .fromString("a7f8f92a-7a4b-484b-937e-42d242e64144");

  public static final UUID ATTRIBUTES_CHART_CHARACTERISTICS = UUID
      .fromString("31182525-9346-4595-81f8-6f91a72ebe06");

  public static final UUID TABULAR_CHART_CHARACTERISTICS = UUID
      .fromString("54e36536-7863-42fd-bea3-c5edd3122fdc");

  public static final UUID COMMANDS_CHART_CHARACTERISTICS = UUID
      .fromString("95b5e1d4-abfa-4a16-818d-a5b07b7d3f73");

  public static final UUID FORMS_CHART_CHARACTERISTICS = UUID
      .fromString("eb2b78a8-40a6-4b7e-b1b3-6ca9966cbc94");
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
      innerClass = V8Reader.read(AttributesDocumentList.class, buffer);
    } else if (guid.equals(COMMAND_LIST_DOCUMENTS)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(TEMPLATES_SECTION_DOCUMENTS)) {
      innerClass = V8Reader.read(TemplateList.class, buffer);
    } else if (guid.equals(UNK_REGISTERS)) { // may be aggregates
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(RESOURCE_REGISTERS)) {
      innerClass = V8Reader.read(ResourceList.class, buffer);
    } else if (guid.equals(DIMENSION_REGISTERS)) {
      innerClass = V8Reader.read(DimensionList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_REGISTERS)) {
      innerClass = V8Reader.read(AttributesRegistersList.class, buffer);
    } else if (guid.equals(FORMS_REGISTERS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(RESOURCE_INFORMATION_REGISTERS)) {
      innerClass = V8Reader.read(InformationResourceList.class, buffer);
    } else if (guid.equals(DIMENSION_INFORMATION_REGISTERS)) {
      innerClass = V8Reader.read(InformationDimensionList.class, buffer);
    } else if (guid.equals(FORMS_INFORMATION_REGISTERS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_INFORMATION_REGISTERS)) {
      innerClass = V8Reader.read(AttributesRegistersList.class, buffer);
    } else if (guid.equals(COMMANDS_INFORMATION_REGISTERS)) {
      innerClass = V8Reader.read(CommandListMetaDataObject.class, buffer);
    } else if (guid.equals(ATTRIBUTES_REPORTS)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(FORM_REPORTS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(TABULARS_REPORTS)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(COMMANDS_REPORTS)) {
      innerClass = V8Reader.read(CommandListMetaDataObject.class, buffer);
    } else if (guid.equals(COMMANDS_DATA_PROCESSORS)) {
      innerClass = V8Reader.read(CommandListMetaDataObject.class, buffer);
    } else if (guid.equals(UNK1_ENUM)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(UNK2_ENUM)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(VALUES_ENUM)) {
      innerClass = V8Reader.read(EnumList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_EXCHANGE_PLANS)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(TABULARS_EXCHANGE_PLANS)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(FORMS_EXCHANGE_PLANS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(COMMANDS_EXCHANGE_PLANS)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(FORMS_FILTER_CRITERIA)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(COMMANDS_FILTER_CRITERIA)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(DATA_SEQUENCES)) {
      innerClass = V8Reader.read(SequencesDataList.class, buffer);
    } else if (guid.equals(FORMS_SETTING_STORAGES)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(FORMS_TASKS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_TASKS)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_ADDRESS_TASKS)) {
      innerClass = V8Reader.read(AttributesAddressList.class, buffer);
    } else if (guid.equals(TABULARS_TASKS)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(COMMANDS_TASKS)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(OPERATION_WEB_SERVICE)) {
      innerClass = V8Reader.read(WebServiceList.class, buffer);
    } else if (guid.equals(OPERATION_PARAMS_WEB_SERVICE)) {
      innerClass = V8Reader.read(OperationParams.class, buffer);
    } else if (guid.equals(ATTRIBUTES_ACCOUNTING)) {
      innerClass = V8Reader.read(AttributesAddressList.class, buffer);
    } else if (guid.equals(RESOURCE_ACCOUNTING)) {
      innerClass = V8Reader.read(AccountingResourceList.class, buffer);
    } else if (guid.equals(COMMANDS_ACCOUNTING)) {
      innerClass = V8Reader.read(CommandListMetaDataObject.class, buffer);
    } else if (guid.equals(DIMENSION_ACCOUNTING_REGISTERS)) {
      innerClass = V8Reader.read(DimensionList.class, buffer);
    } else if (guid.equals(FORMS_ACCOUNTING_REGISTERS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(DIMENSION_CALCULATION_REGISTERS)) {
      innerClass = V8Reader.read(CalculationDimensionList.class, buffer);
    } else if (guid.equals(UNK1_CALCULATION_REGISTERS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(RESOURCE_CALCULATION_REGISTERS)) {
      innerClass = V8Reader.read(CalculationResourceList.class, buffer);
    } else if (guid.equals(UNK2_CALCULATION_REGISTERS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(UNK3_CALCULATION_REGISTERS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_CALCULATION_REGISTERS)) {
      innerClass = V8Reader.read(CalculationAttributesList.class, buffer);
    } else if (guid.equals(TABULAR_CHART_ACCOUNT)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(COMMANDS_CHART_ACCOUNT)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(FORMS_CHART_ACCOUNT)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_CHART_ACCOUNT)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(FLAGS_CHART_ACCOUNT)) {
      innerClass = V8Reader.read(AccountingFlags.class, buffer);
    } else if (guid.equals(EXT_DIMENTION_FLAGS_CHART_ACCOUNT)) {
      innerClass = V8Reader.read(ExtDimensionAccountingFlags.class, buffer);
    } else if (guid.equals(TABULAR_CHART_CALCULATION)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_CHART_CALCULATION)) {
      innerClass = V8Reader.read(AttributesList.class, buffer);
    } else if (guid.equals(COMMANDS_CHART_CALCULATION)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(FORMS_CHART_CALCULATION)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    } else if (guid.equals(TABULAR_CHART_CHARACTERISTICS)) {
      innerClass = V8Reader.read(TabularList.class, buffer);
    } else if (guid.equals(ATTRIBUTES_CHART_CHARACTERISTICS)) {
      innerClass = V8Reader.read(ChartsOfCharacteristicTypesAttributesList.class, buffer);
    } else if (guid.equals(COMMANDS_CHART_CHARACTERISTICS)) {
      innerClass = V8Reader.read(CommandList.class, buffer);
    } else if (guid.equals(FORMS_CHART_CHARACTERISTICS)) {
      innerClass = V8Reader.read(FormList.class, buffer);
    }

    else {
      throw new RuntimeException("Unknown section: " + guid);
    }

    return innerClass;
  }
}

package com.minimajack.v8.metadata.inner.classes.transformer;

import com.minimajack.v8.metadata.catalog.CharacteristicsDescription;
import com.minimajack.v8.metadata.external.PatternDescription;
import com.minimajack.v8.metadata.external.common.ChoiceParameterLinks;
import com.minimajack.v8.metadata.external.common.ChoiceParameters;
import com.minimajack.v8.metadata.external.common.MetaDataObjectLink;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.LinkByType;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntNotReqUuid;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntUuidUuid;
import com.minimajack.v8.metadata.external.unknown.UnkObjectUuidInt;
import com.minimajack.v8.metadata.functionaloption.FunctionalOptionContentItem;
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
import com.minimajack.v8.metadata.inner.classes.collection.FixedArray;
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
import com.minimajack.v8.metadata.inner.classes.documentjournal.ColumnList;
import com.minimajack.v8.metadata.inner.classes.enums.EnumList;
import com.minimajack.v8.metadata.inner.classes.enums.StandartPeriod;
import com.minimajack.v8.metadata.inner.classes.externaldataprocessor.ExternalDataProcessorMetaData;
import com.minimajack.v8.metadata.inner.classes.forms.FormList;
import com.minimajack.v8.metadata.inner.classes.httpservice.HttpMethods;
import com.minimajack.v8.metadata.inner.classes.httpservice.UrlTemplates;
import com.minimajack.v8.metadata.inner.classes.sequences.SequencesDataList;
import com.minimajack.v8.metadata.inner.classes.style.border.Border;
import com.minimajack.v8.metadata.inner.classes.style.color.Color;
import com.minimajack.v8.metadata.inner.classes.style.font.Font;
import com.minimajack.v8.metadata.inner.classes.tabular.TabularList;
import com.minimajack.v8.metadata.inner.classes.template.TemplateList;
import com.minimajack.v8.metadata.inner.classes.webservices.OperationParams;
import com.minimajack.v8.metadata.inner.classes.webservices.WebServiceList;
import com.minimajack.v8.metadata.inner.enums.AccountType;
import com.minimajack.v8.metadata.inner.enums.ApplicationUsePurpose;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.FillChecking;
import com.minimajack.v8.metadata.inner.enums.RequiredMobileApplicationPermissions;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InnerClassTransformer extends AbstractTransformer<V8InnerClass> {

  public static final UUID FORMS_SECTION = UUID
      .fromString("d5b0e5ed-256d-401c-9c36-f630cafd8a62");

  public static final UUID FORMS = UUID.fromString("fdf816d2-1ead-11d5-b975-0050bae0a95d");

  public static final UUID TEMPLATE_SECTION = UUID
      .fromString("3daea016-69b7-4ed4-9453-127911372fe6");

  public static final UUID ATTRIBUTES_SECTION = UUID
      .fromString("ec6bb5e5-b7a8-4d75-bec9-658107a699cf");

  public static final UUID TABULAR_ATTRIBUTES_SECTION = UUID
      .fromString("888744e1-b616-11d4-9436-004095e12fc7");

  public static final UUID DATAPROCESSOR_TABULAR_ATTRIBUTES_SECTION = UUID
      .fromString("5d24a9d1-098e-11d6-b9b8-0050bae0a95d");

  public static final UUID REPORT_TABULAR_ATTRIBUTES_SECTION = UUID
      .fromString("c339c860-29e2-11d6-a3c7-0050bae0a776");

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

  public static final UUID COLUMNS_DOCUMENT_JOURNAL = UUID
      .fromString("5aee69df-0513-4c6c-9815-103102471712");

  public static final UUID COMMANDS_DOCUMENT_JOURNAL = UUID
      .fromString("a49a35ce-120a-4c80-8eea-b0618479cd70");

  public static final UUID FORMS_DOCUMENT_JOURNAL = UUID
      .fromString("ec81ad10-ca07-11d5-b9a5-0050bae0a95d");

  public static final UUID FORMS_BUSINESS_PROCESS = UUID
      .fromString("3f7a8120-b71a-4265-98bf-4d9bc09b7719");

  public static final UUID COMMANDS_BUSINESS_PROCESS = UUID
      .fromString("7a3e533c-f232-40d5-a932-6a311d2480bf");

  public static final UUID ATTRIBUTES_BUSINESS_PROCESS = UUID
      .fromString("87c988de-ecbf-413b-87b0-b9516df05e28");

  public static final UUID TABULARS_BUSINESS_PROCESS = UUID
      .fromString("a3fe6537-d787-40f7-8a06-419d2f0c1cfd");

  public static final UUID URL_TEMPLATES_HTTP_SERVICE = UUID
      .fromString("ec6896c2-9b28-42d8-9140-48491146b8ea");

  public static final UUID METHODS_HTTP_SERVICE = UUID
      .fromString("21c96ea8-c8fc-424a-a0b4-e1ffb2fa1a73");

  private static final UUID ENUM_FILL_CHEKING = UUID
      .fromString("98ea8e5a-b586-442b-b944-6e3447734aa7");

  private static final UUID LINK_BY_TYPE = UUID
      .fromString("9ad557b1-249e-48dc-824b-3e149ecf10a6");

  private static final UUID CREATE_ON_INPUT = UUID
      .fromString("ad3615c5-aae6-4725-89be-91827523abd9");

  private static final UUID MULTILANGUAGE_STRING = UUID
      .fromString("87024738-fc2a-4436-ada1-df79d395c424");

  private static final UUID METADATA_OBJECT = UUID
      .fromString("157fa490-4ce9-11d4-9415-008048da11f9");

  private static final UUID FUNCTIONAL_OPTION_VALUE = UUID
      .fromString("3ea29ea5-66f6-4e3b-8595-d8940db766a2");

  private static final UUID ENUM_USE_QUICK_CHOICE = UUID
      .fromString("ace3fd07-11b2-477e-ab7f-36f0ea37c8dd");

  private static final UUID ENUM_CHOICE_HISTORY_ON_INPUT = UUID
      .fromString("12ca4003-ac70-450e-b897-37faf86bd313");

  private static final UUID ENUM_FULL_TEXT_SEARCH = UUID
      .fromString("3b8e6bdd-d648-49d5-af2f-d46d84f87dd5");

  private static final UUID CHOICE_PARAMETER_LINKS = UUID
      .fromString("b76a58b9-2a56-4e46-bb31-8e04ad9f31ae");

  private static final UUID CHOICE_PARAMETERS = UUID
      .fromString("f2eaae14-91a7-47b9-9d69-097877f41580");

  private static final UUID PREDEFINED_TYPE_11 = UUID
      .fromString("5c14e26f-099b-4d37-84a6-b433d87400da");

  private static final UUID FIXED_ARRAY = UUID
      .fromString("4500381b-db30-4a10-9db4-990038032acf");

  private static final UUID ENUM_APPLICATION_USE_PURPOSE = UUID
      .fromString("1708fdaa-cbce-4289-b373-07a5a74bee91");

  private static final UUID REQUIRED_MOBILE_APPLICATION_PERMISSIONS = UUID
      .fromString("e4c53f94-e5f7-4a34-8c10-218bd811cae1");

  private static final UUID COMPOSITE_ID = UUID
      .fromString("60ea359f-3a6e-48bb-8e71-d2a457572918");

  private static final UUID CHARACTERISTICS_DESCRIPTION = UUID
      .fromString("fe839d42-d094-40ba-b903-75bccc21ba30");

  private static final UUID STANDART_PERIOD = UUID
      .fromString("2fdc88ec-7c9b-43cd-8ba5-873f043bdd88");

  private static final UUID COLOR = UUID.fromString("9cd510c7-abfc-11d4-9434-004095e12fc7");

  private static final UUID FONT = UUID.fromString("9cd510c8-abfc-11d4-9434-004095e12fc7");

  private static final UUID BORDER = UUID.fromString("4d10ca00-111a-4d43-9c96-92cd773716de");

  private static final UUID ACCOUNT_TYPE = UUID
      .fromString("872f7198-7083-4e3e-b57e-a2a9802c769e");

  private static final UUID TYPE_DESCRIPTION = UUID
      .fromString("f5c65050-3bbb-11d5-b988-0050bae0a95d");

  private final Map<UUID, Class<? extends V8InnerClass>> classbyUUID =
      new HashMap<UUID, Class<? extends V8InnerClass>>();
  {
    this.classbyUUID.put(FORMS_SECTION, FormList.class);
    this.classbyUUID.put(TEMPLATE_SECTION, TemplateList.class);
    this.classbyUUID.put(TABULAR_ATTRIBUTES_SECTION, AttributesList.class);
    this.classbyUUID.put(DATAPROCESSOR_TABULAR_ATTRIBUTES_SECTION, AttributesList.class);
    this.classbyUUID.put(REPORT_TABULAR_ATTRIBUTES_SECTION, AttributesList.class);
    this.classbyUUID.put(ATTRIBUTES_SECTION, AttributesList.class);
    this.classbyUUID.put(TABULAR_SECTION, TabularList.class);
    this.classbyUUID.put(ROLE_SECTION, Roles.class);
    this.classbyUUID.put(COMMON_TEMPLATES_SECTION, CommonTemplates.class);
    this.classbyUUID.put(COMMON_MODULES_SECTION, CommonModules.class);
    this.classbyUUID.put(SCHEDULED_JOBS_SECTION, ScheduledJobs.class);
    this.classbyUUID.put(COMMON_ATTRIBUTES_SECTION, CommonAttributes.class);
    this.classbyUUID.put(SESSION_PARAMS_SECTION, SessionParams.class);
    this.classbyUUID.put(FUNC_OPTIONS_PARAMS_SECTION, FunctionalOptionParams.class);
    this.classbyUUID.put(HTTP_SERVICES_SECTION, HttpServices.class);
    this.classbyUUID.put(SUBSYSTEMS_SECTION, Subsystems.class);
    this.classbyUUID.put(INTERFACES_SECTION, Interfaces.class);
    this.classbyUUID.put(STYLES_SECTION, Styles.class);
    this.classbyUUID.put(FILTER_CRITERIA_SECTION, FilterCriteria.class);
    this.classbyUUID.put(SETTINGS_STORAGES_SECTION, SettingsStorages.class);
    this.classbyUUID.put(EVENT_SUBSCRIPTIONS_SECTION, EventSubscriptions.class);
    this.classbyUUID.put(STYLE_ITEMS_SECTION, StyleItems.class);
    this.classbyUUID.put(COMMON_PICTURES_SECTION, CommonPictures.class);
    this.classbyUUID.put(EXCHANGE_PLANS_SECTION, ExchangePlans.class);
    this.classbyUUID.put(WEB_SERVICES_SECTION, WebServices.class);
    this.classbyUUID.put(LANGUAGES_SECTION, Languages.class);
    this.classbyUUID.put(FUNCTIONAL_OPTIONS_SECTION, FunctionalOptions.class);
    this.classbyUUID.put(DEFINED_TYPES_SECTION, DefinedTypes.class);
    this.classbyUUID.put(XDTO_PACKAGES_SECTION, XdtoPackages.class);
    this.classbyUUID.put(WS_REFERENCES_SECTION, WsReferences.class);
    this.classbyUUID.put(CONSTANTS_SECTION, Constants.class);
    this.classbyUUID.put(DOCUMENTS_SECTION, Documents.class);
    this.classbyUUID.put(COMMON_FORMS_SECTION, CommonForms.class);
    this.classbyUUID.put(INFORMATION_REGISTERS_SECTION, InformationRegisters.class);
    this.classbyUUID.put(COMMAND_GROUPS_SECTION, CommandGroups.class);
    this.classbyUUID.put(COMMON_COMMANDS_SECTION, CommonCommands.class);
    this.classbyUUID.put(DOCUMENT_NUMERATORS_SECTION, DocumentNumerators.class);
    this.classbyUUID.put(DOCUMENT_JOURNALS_SECTION, DocumentJournals.class);
    this.classbyUUID.put(REPORTS_SECTION, Reports.class);
    this.classbyUUID
        .put(CHARTS_OF_CHARACTERISTIC_TYPES_SECTION, ChartsOfCharacteristicTypes.class);
    this.classbyUUID.put(ACCUMULATION_REGISTERS_SECTION, AccumulationRegisters.class);
    this.classbyUUID.put(SEQUENCES_SECTION, Sequences.class);
    this.classbyUUID.put(DATA_PROCESSORS_SECTION, DataProcessors.class);
    this.classbyUUID.put(CATALOGS_SECTION, Catalogs.class);
    this.classbyUUID.put(ENUMS_SECTION, Enums.class);
    this.classbyUUID.put(CHARTS_OF_ACCOUNTS_SECTION, ChartsOfAccounts.class);
    this.classbyUUID.put(ACCOUNTING_REGISTERS_SECTION, AccountingRegisters.class);
    this.classbyUUID.put(CHARTS_OF_CALCULATION_TYPES_SECTION, ChartsOfCalculation.class);
    this.classbyUUID.put(CALCULATION_REGISTERS_SECTION, CalculationRegisters.class);
    this.classbyUUID.put(TASKS_SECTION, Tasks.class);
    this.classbyUUID.put(BUSINESS_PROCESSES_SECTION, BusinessProcesses.class);
    this.classbyUUID.put(EXTERNAL_DATA_SOURCES_SECTION, ExternalDataSources.class);
    this.classbyUUID.put(EXTERNAL_DATA_PROCESSOR, ExternalDataProcessorMetaData.class);
    this.classbyUUID.put(COMMON_CONFIGURATION_BLOCK, CommonConfiguraionMetaData.class);
    this.classbyUUID.put(MAIN_CONFIGURATION_BLOCK, MainConfiguraionMetaData.class);
    this.classbyUUID.put(ACCOUNTING_CONFIGURATION_BLOCK, AccountingConfiguraionMetaData.class);
    this.classbyUUID.put(CALCULATION_CONFIGURATION_BLOCK, CalculationConfiguraionMetaData.class);
    this.classbyUUID
        .put(BUSINESS_PROCESSES_CONFIGURATION_BLOCK, BusinessProcessesConfiguraionMetaData.class);
    this.classbyUUID
        .put(EXTERNAL_DATA_SOURCES_CONFIGURATION_BLOCK, ExternalDataSourcesConfiguraionMetaData.class);
    this.classbyUUID.put(COMMAND_LIST, CommandList.class);
    this.classbyUUID.put(TABULARS, TabularList.class);
    this.classbyUUID.put(ATTRIBUTES, AttributesList.class);
    this.classbyUUID.put(FORMS, FormList.class);
    this.classbyUUID.put(TABULAR_DOCUMENTS, TabularList.class);
    this.classbyUUID.put(ATTRIBUTES_DOCUMENTS, AttributesDocumentList.class);
    this.classbyUUID.put(COMMAND_LIST_DOCUMENTS, CommandList.class);
    this.classbyUUID.put(TEMPLATES_SECTION_DOCUMENTS, TemplateList.class);
    this.classbyUUID.put(UNK_REGISTERS, FormList.class);
    this.classbyUUID.put(RESOURCE_REGISTERS, ResourceList.class);
    this.classbyUUID.put(DIMENSION_REGISTERS, DimensionList.class);
    this.classbyUUID.put(ATTRIBUTES_REGISTERS, AttributesRegistersList.class);
    this.classbyUUID.put(FORMS_REGISTERS, FormList.class);
    this.classbyUUID.put(RESOURCE_INFORMATION_REGISTERS, InformationResourceList.class);
    this.classbyUUID.put(DIMENSION_INFORMATION_REGISTERS, InformationDimensionList.class);
    this.classbyUUID.put(FORMS_INFORMATION_REGISTERS, FormList.class);
    this.classbyUUID.put(ATTRIBUTES_INFORMATION_REGISTERS, AttributesRegistersList.class);
    this.classbyUUID.put(COMMANDS_INFORMATION_REGISTERS, CommandListMetaDataObject.class);
    this.classbyUUID.put(ATTRIBUTES_REPORTS, AttributesList.class);
    this.classbyUUID.put(FORM_REPORTS, FormList.class);
    this.classbyUUID.put(TABULARS_REPORTS, TabularList.class);
    this.classbyUUID.put(COMMANDS_REPORTS, CommandListMetaDataObject.class);
    this.classbyUUID.put(COMMANDS_DATA_PROCESSORS, CommandListMetaDataObject.class);
    this.classbyUUID.put(UNK1_ENUM, FormList.class);
    this.classbyUUID.put(UNK2_ENUM, FormList.class);
    this.classbyUUID.put(VALUES_ENUM, EnumList.class);
    this.classbyUUID.put(ATTRIBUTES_EXCHANGE_PLANS, AttributesList.class);
    this.classbyUUID.put(TABULARS_EXCHANGE_PLANS, TabularList.class);
    this.classbyUUID.put(FORMS_EXCHANGE_PLANS, FormList.class);
    this.classbyUUID.put(COMMANDS_EXCHANGE_PLANS, CommandList.class);
    this.classbyUUID.put(FORMS_FILTER_CRITERIA, FormList.class);
    this.classbyUUID.put(COMMANDS_FILTER_CRITERIA, CommandList.class);
    this.classbyUUID.put(DATA_SEQUENCES, SequencesDataList.class);
    this.classbyUUID.put(FORMS_SETTING_STORAGES, FormList.class);
    this.classbyUUID.put(FORMS_TASKS, FormList.class);
    this.classbyUUID.put(ATTRIBUTES_TASKS, AttributesList.class);
    this.classbyUUID.put(ATTRIBUTES_ADDRESS_TASKS, AttributesAddressList.class);
    this.classbyUUID.put(TABULARS_TASKS, TabularList.class);
    this.classbyUUID.put(COMMANDS_TASKS, CommandList.class);
    this.classbyUUID.put(OPERATION_WEB_SERVICE, WebServiceList.class);
    this.classbyUUID.put(OPERATION_PARAMS_WEB_SERVICE, OperationParams.class);
    this.classbyUUID.put(ATTRIBUTES_ACCOUNTING, AttributesAddressList.class);
    this.classbyUUID.put(RESOURCE_ACCOUNTING, AccountingResourceList.class);
    this.classbyUUID.put(COMMANDS_ACCOUNTING, CommandListMetaDataObject.class);
    this.classbyUUID.put(DIMENSION_ACCOUNTING_REGISTERS, DimensionList.class);
    this.classbyUUID.put(FORMS_ACCOUNTING_REGISTERS, FormList.class);
    this.classbyUUID.put(DIMENSION_CALCULATION_REGISTERS, CalculationDimensionList.class);
    this.classbyUUID.put(UNK1_CALCULATION_REGISTERS, FormList.class);
    this.classbyUUID.put(RESOURCE_CALCULATION_REGISTERS, CalculationResourceList.class);
    this.classbyUUID.put(UNK2_CALCULATION_REGISTERS, FormList.class);
    this.classbyUUID.put(UNK3_CALCULATION_REGISTERS, FormList.class);
    this.classbyUUID.put(ATTRIBUTES_CALCULATION_REGISTERS, CalculationAttributesList.class);
    this.classbyUUID.put(TABULAR_CHART_ACCOUNT, TabularList.class);
    this.classbyUUID.put(COMMANDS_CHART_ACCOUNT, CommandList.class);
    this.classbyUUID.put(FORMS_CHART_ACCOUNT, FormList.class);
    this.classbyUUID.put(ATTRIBUTES_CHART_ACCOUNT, AttributesList.class);
    this.classbyUUID.put(FLAGS_CHART_ACCOUNT, AccountingFlags.class);
    this.classbyUUID.put(EXT_DIMENTION_FLAGS_CHART_ACCOUNT, ExtDimensionAccountingFlags.class);
    this.classbyUUID.put(TABULAR_CHART_CALCULATION, TabularList.class);
    this.classbyUUID.put(ATTRIBUTES_CHART_CALCULATION, AttributesList.class);
    this.classbyUUID.put(COMMANDS_CHART_CALCULATION, CommandList.class);
    this.classbyUUID.put(FORMS_CHART_CALCULATION, FormList.class);
    this.classbyUUID.put(TABULAR_CHART_CHARACTERISTICS, TabularList.class);
    this.classbyUUID
        .put(ATTRIBUTES_CHART_CHARACTERISTICS, ChartsOfCharacteristicTypesAttributesList.class);
    this.classbyUUID.put(COMMANDS_CHART_CHARACTERISTICS, CommandList.class);
    this.classbyUUID.put(FORMS_CHART_CHARACTERISTICS, FormList.class);
    this.classbyUUID.put(COLUMNS_DOCUMENT_JOURNAL, ColumnList.class);
    this.classbyUUID.put(COMMANDS_DOCUMENT_JOURNAL, CommandListMetaDataObject.class);
    this.classbyUUID.put(FORMS_DOCUMENT_JOURNAL, FormList.class);
    this.classbyUUID.put(FORMS_BUSINESS_PROCESS, FormList.class);
    this.classbyUUID.put(COMMANDS_BUSINESS_PROCESS, CommandList.class);
    this.classbyUUID.put(ATTRIBUTES_BUSINESS_PROCESS, AttributesList.class);
    this.classbyUUID.put(TABULARS_BUSINESS_PROCESS, TabularList.class);
    this.classbyUUID.put(URL_TEMPLATES_HTTP_SERVICE, UrlTemplates.class);
    this.classbyUUID.put(METHODS_HTTP_SERVICE, HttpMethods.class);
    this.classbyUUID.put(ENUM_FILL_CHEKING, FillChecking.class);
    this.classbyUUID.put(LINK_BY_TYPE, LinkByType.class);
    this.classbyUUID.put(CREATE_ON_INPUT, UnkObjectUuidInt.class);
    this.classbyUUID.put(MULTILANGUAGE_STRING, V8Synonym.class);
    this.classbyUUID.put(METADATA_OBJECT, MetaDataObjectLink.class);
    this.classbyUUID.put(ENUM_USE_QUICK_CHOICE, UnkObjectUuidInt.class);
    this.classbyUUID.put(ENUM_CHOICE_HISTORY_ON_INPUT, ChoiceHistoryOnInput.class);
    this.classbyUUID.put(ENUM_FULL_TEXT_SEARCH, UnkObjectUuidInt.class);
    this.classbyUUID.put(CHOICE_PARAMETER_LINKS, ChoiceParameterLinks.class);
    this.classbyUUID.put(CHOICE_PARAMETERS, ChoiceParameters.class);
    this.classbyUUID.put(PREDEFINED_TYPE_11, UnkObjectIntUuidUuid.class);
    this.classbyUUID.put(FIXED_ARRAY, FixedArray.class);
    this.classbyUUID.put(ENUM_APPLICATION_USE_PURPOSE, ApplicationUsePurpose.class);
    this.classbyUUID
        .put(REQUIRED_MOBILE_APPLICATION_PERMISSIONS, RequiredMobileApplicationPermissions.class);
    this.classbyUUID.put(FUNCTIONAL_OPTION_VALUE, FunctionalOptionContentItem.class);
    this.classbyUUID.put(COMPOSITE_ID, UnkObjectIntNotReqUuid.class);
    this.classbyUUID.put(CHARACTERISTICS_DESCRIPTION, CharacteristicsDescription.class);
    this.classbyUUID.put(STANDART_PERIOD, StandartPeriod.class);
    this.classbyUUID.put(COLOR, Color.class);
    this.classbyUUID.put(FONT, Font.class);
    this.classbyUUID.put(BORDER, Border.class);
    this.classbyUUID.put(ACCOUNT_TYPE, AccountType.class);
    this.classbyUUID.put(TYPE_DESCRIPTION, PatternDescription.class);
  }

  @Override
  public V8InnerClass read(final ParameterizedType type, final ByteBuffer buffer) {
    buffer.mark();
    V8InnerClass innerClass = null;
    final UUID classUUID = V8Reader.read(UUID.class, buffer);
    if (this.classbyUUID.containsKey(classUUID)) {
      V8Reader.readChar(buffer, ',');
      innerClass = V8Reader.read(this.classbyUUID.get(classUUID), buffer);
    } else {
      throw new RuntimeException("Undefined class uuid: " + classUUID);
    }
    return innerClass;
  }
}
